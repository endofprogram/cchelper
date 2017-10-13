package org.eop.java.cchelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

import com.cmos.core.bean.InputObject;
import com.cmos.core.bean.OutputObject;
import com.cmos.crmpfcore.bean.InterfaceEntity;
import com.cmos.crmpfcore.frame.IOutIntfProcessService;

/**
 * @author lixinjie
 * @since 2017-09-27
 */
public class Caller {
	
	public Map<String, Map<String, Object>> call(InputObject inputObject, List<InterfaceEntity> inters, IOutIntfProcessService outIntfProcess) throws InterruptedException, ExecutionException {
		return call(inputObject, inters, null, outIntfProcess);
	}
	
	public Map<String, Map<String, Object>> call(InputObject inputObject, List<InterfaceEntity> inters, List<String> codes, IOutIntfProcessService outIntfProcess) throws InterruptedException, ExecutionException {
		IInters itrs = new Inters();
		setInterfaces(itrs, filterInterfaceByCode(inters, codes));
		IExeInters exeInters = new ExeInters(outIntfProcess);
		prepareExeInters(exeInters, itrs);
		return exeInters.execute(inputObject);
	}
	
	protected void setInterfaces(IInters itrs, List<InterfaceEntity> inters) {
		for (InterfaceEntity inter : inters) {
			addInterface(itrs, inter);
		}
	}
	
	protected void addInterface(IInters inters, InterfaceEntity inter) {
		IInter itr = inters.getMatched(inter);
		if (itr != null) {
			itr.setInter(inter);
		} else {
			IInter it = new Inter();
			it.setInter(inter);
			inters.addInter(it);
		}
	}
	
	protected void prepareExeInters(IExeInters exeInters, IInters inters) {
		IExeInter exeInter = null;
		for (IInter inter : inters.getInters()) {
			if (exeInter == null) {
				exeInter = new ExeInter();
			}
			if (!exeInter.addInter(inter)) {
				exeInters.addExeInter(exeInter);
				exeInter = new ExeInter();
				exeInter.addInter(inter);
			}
		}
		if (exeInter != null) {
			exeInters.addExeInter(exeInter);
		}
	}
	
	protected List<InterfaceEntity> filterInterfaceByCode(List<InterfaceEntity> inters, List<String> codes) {
		List<InterfaceEntity> itrs = new ArrayList<>();
		if (codes == null || codes.isEmpty()) {
			itrs.addAll(inters);
		} else {
			for (InterfaceEntity inter : inters) {
				if (codes.contains(getCode(inter.getIntfBizCode()))) {
					itrs.add(inter);
				}
			}
		}
		return itrs;
	}
	
	protected String getCode(String interFlag) {
		return interFlag.substring(2, interFlag.length() - 3);
	}
	

	public interface IInter {
		
		InterfaceEntity getInInter();
		
		InterfaceEntity getOutInter();
		
		boolean match(InterfaceEntity inter);
		
		void setInter(InterfaceEntity inter);
		
		boolean isCoupled();
		
		Integer getOrder();
		
		String getName();
	}
	
	public interface IInters {
		
		List<IInter> getInters();
		
		void addInter(IInter inter);
		
		IInter getMatched(InterfaceEntity inter);
	}
	
	public interface IExeInter {
		
		List<IInter> getInters();
		
		boolean addInter(IInter inter);
		
		Integer getOrder();
		
		Integer getCount();
		
		Map<String, Map<String, Object>> execute(InputObject inputObject) throws InterruptedException, ExecutionException;
	}
	
	public interface IExeInters {
		
		List<IExeInter> getExeInters();
		
		void addExeInter(IExeInter exeInter);
		
		Integer getMaxCount();
		
		Map<String, Map<String, Object>> execute(InputObject inputObject) throws InterruptedException, ExecutionException;
	}
	
	public static class Inter implements IInter {

		private InterfaceEntity inInter;
		private InterfaceEntity outInter;
		
		@Override
		public InterfaceEntity getInInter() {
			return inInter;
		}

		@Override
		public InterfaceEntity getOutInter() {
			return outInter;
		}

		@Override
		public boolean match(InterfaceEntity inter) {
			if (inInter != null && isOutInter(inter.getIntfBizCode())) {
				if (getName(inInter.getIntfBizCode()).equals(getName(inter.getIntfBizCode()))) {
					return true;
				}
			}
			if (outInter != null && !isOutInter(inter.getIntfBizCode())) {
				if (getName(outInter.getIntfBizCode()).equals(getName(inter.getIntfBizCode()))) {
					return true;
				}
			}
			return false;
		}

		@Override
		public void setInter(InterfaceEntity inter) {
			if (isOutInter(inter.getIntfBizCode())) {
				outInter = inter;
			} else {
				inInter = inter;
			}
		}

		@Override
		public boolean isCoupled() {
			return inInter != null && outInter != null;
		}

		@Override
		public Integer getOrder() {
			return getOrder(outInter.getIntfBizCode());
		}

		@Override
		public String getName() {
			return getName(outInter.getIntfBizCode());
		}
		
		protected Integer getOrder(String interFlag) {
			return Integer.valueOf(interFlag.substring(interFlag.length() - 2));
		}
		
		protected String getName(String interFlag) {
			return interFlag.substring(2, interFlag.length() - 3);
		}
		
		protected boolean isOutInter(String interFlag) {
			return interFlag.startsWith("o");
		}
	}
	
	public static class Inters implements IInters {

		private List<IInter> inters = new ArrayList<>();
		
		@Override
		public List<IInter> getInters() {
			//从小到大排序
			sortedByOrder();
			return inters;
		}

		@Override
		public void addInter(IInter inter) {
			inters.add(inter);
		}

		@Override
		public IInter getMatched(InterfaceEntity inter) {
			for (IInter itr : inters) {
				if (!itr.isCoupled() && itr.match(inter)) {
					return itr;
				}
			}
			return null;
		}

		protected void sortedByOrder() {
			Collections.sort(inters, new Comparator<IInter>() {

				@Override
				public int compare(IInter inter1, IInter inter2) {
					return inter1.getOrder() - inter2.getOrder();
				}});
		}
	}
	
	public static class ExeInter implements IExeInter {

		private IOutIntfProcessService outIntfProcess;
		private CompletionService<Map<String, Map<String, Object>>> completionService;
		
		
		public void setOutIntfProcess(IOutIntfProcessService outIntfProcess) {
			this.outIntfProcess = outIntfProcess;
		}

		public void setCompletionService(CompletionService<Map<String, Map<String, Object>>> completionService) {
			this.completionService = completionService;
		}

		private List<IInter> inters = new ArrayList<>();
		
		@Override
		public List<IInter> getInters() {
			return inters;
		}

		@Override
		public boolean addInter(IInter inter) {
			if (getOrder() < 0) {
				inters.add(inter);
				return true;
			}
			if (getOrder() == inter.getOrder()) {
				inters.add(inter);
				return true;
			}
			return false;
		}

		@Override
		public Integer getOrder() {
			if (!inters.isEmpty()) {
				return inters.get(0).getOrder();
			}
			return -1;
		}
		
		@Override
		public Integer getCount() {
			return inters.size();
		}

		@Override
		public Map<String, Map<String, Object>> execute(final InputObject inputObject) throws InterruptedException, ExecutionException {
			for (final IInter inter : inters) {
				completionService.submit(new Callable<Map<String, Map<String, Object>>>() {

					@SuppressWarnings("unchecked")
					@Override
					public Map<String, Map<String, Object>> call() throws Exception {
						OutputObject outputObject = outIntfProcess.process(inputObject, inter.getInInter(), inter.getOutInter());
						Map<String, Map<String, Object>> output = new HashMap<>();
						output.put(inter.getName(), (Map<String, Object>)outputObject.getObject());
						return output;
					}});
			}
			
			Map<String, Map<String, Object>> output = new HashMap<>();
			for (int i = 0, count = getCount(); i < count; i++) {
				output.putAll(completionService.take().get());
			}
			return output;
		}
		
	}
	
	public static class ExeInters implements IExeInters {

		private IOutIntfProcessService outIntfProcess;
		private List<IExeInter> exeInters = new ArrayList<>();
		
		public ExeInters(IOutIntfProcessService outIntfProcess) {
			this.outIntfProcess = outIntfProcess;
		}
		
		@Override
		public List<IExeInter> getExeInters() {
			return exeInters;
		}

		@Override
		public void addExeInter(IExeInter exeInter) {
			exeInters.add(exeInter);
		}
		
		@Override
		public Integer getMaxCount() {
			int maxCount = 0;
			for (IExeInter exeInter : exeInters) {
				if (exeInter.getCount() > maxCount) {
					maxCount = exeInter.getCount();
				}
			}
			return maxCount;
		}

		@Override
		public Map<String, Map<String, Object>> execute(InputObject inputObject) throws InterruptedException, ExecutionException {
			//从小到大排序
			sortedByOrder();
			//获得执行器
			CompletionService<Map<String, Map<String, Object>>> completionService = prepareCompletionService();
			
			Map<String, Map<String, Object>> resultMap = new HashMap<>();
			for (IExeInter exeInter : exeInters) {
				((ExeInter)exeInter).setOutIntfProcess(outIntfProcess);
				((ExeInter)exeInter).setCompletionService(completionService);
				resultMap.putAll(exeInter.execute(inputObject));
			}
			return resultMap;
		}
		
		protected CompletionService<Map<String, Map<String, Object>>> prepareCompletionService() {
			return new ExecutorCompletionService<Map<String, Map<String, Object>>>(Executors.newFixedThreadPool(getMaxCount()));
		}
		
		protected void sortedByOrder() {
			Collections.sort(exeInters, new Comparator<IExeInter>() {

				@Override
				public int compare(IExeInter inter1, IExeInter inter2) {
					return inter1.getOrder() - inter2.getOrder();
				}});
		}
	}
}
