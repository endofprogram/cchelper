package org.eop.java.cchelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixinjie
 * @since 2017-09-24
 */
public class Builder {
	
	private ICElement root;
	private ICElement curr;
	
	private Builder(Clawer clawer) {
		root = new Root(clawer);
		curr = root;
	}
	
	public static Builder from(Clawer clawer) {
		return new Builder(clawer);
	}
	
	public Builder kv(String name, String path) {
		curr.addChild(new KeyValue(curr, name, path));
		return this;
	}
	
	public Builder ko(String name) {
		return ko(name, null);
	}
	
	public Builder ko(String name, String path) {
		KeyObject keyObject = new KeyObject(curr, name, path);
		curr.addChild(keyObject);
		curr = keyObject;
		return this;
	}
	
	public Builder ka(String name) {
		return ka(name, null);
	}
	
	public Builder ka(String name, String path) {
		KeyArray keyArray = new KeyArray(curr, name, path);
		curr.addChild(keyArray);
		curr = keyArray;
		return this;
	}
	
	public Builder iv() {
		return iv(null);
	}
	
	public Builder iv(String path) {
		curr.addChild(new ItemValue(curr, path));
		return this;
	}
	
	public Builder io() {
		return io(null);
	}
	
	public Builder io(String path) {
		ItemObject itemObject = new ItemObject(curr, path);
		curr.addChild(itemObject);
		curr = itemObject;
		return this;
	}
	
	public Builder end() {
		curr = curr.getParent();
		return this;
	}
	
	public String toJson() {
		return toJson(false);
	}
	
	public String toJson(boolean format) {
		StringBuilder sb = new StringBuilder(512);
		if (format) {
			root.toJson(0, sb);
		} else {
			root.toJson(sb);
		}
		return sb.toString();
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		root.toMap(new MapArrayHolder(map));
		return map;
	}
	
	public interface IElement extends IPath {
		
		ICElement getParent();
		
		Clawer getClawer();
		
		void toJson(StringBuilder sb);
		
		void toJson(int indent, StringBuilder sb);
		
		void toMap(MapArrayHolder holder);
	}
	
	public interface ICElement extends IElement {
		
		void addChild(IElement element);
		
		ElementList getChildren();
	}
	
	public interface IName {
		
		String getName();
	}
	
	public interface IPath {
		
		String getPath();
	}
	
	public interface IIndex {
		
		Integer getIndex();
		
		void updateIndex(Integer index);
	}
	
	public interface IClawer {
		
		void updateClawer();
	}
	
	public interface IKeyValue extends IName, IElement {
		
	}
	
	public interface IKeyObject extends IName, ICElement {
		
	}
	
	public interface IKeyArray extends IName, ICElement {
		
	}
	
	public interface IItemValue extends IElement, IIndex {
		
	}
	
	public interface IItemObject extends ICElement, IIndex, IClawer {
		
	}
	
	public interface IRoot extends ICElement {
		
	}
	
	public static abstract class AbstractElement implements IElement {
		
		protected ICElement parent;
		protected String path;
		
		protected AbstractElement(ICElement parent, String path) {
			this.parent = parent;
			this.path = path;
		}
		
		@Override
		public ICElement getParent() {
			return parent;
		}

		@Override
		public String getPath() {
			return path;
		}
		
		@Override
		public Clawer getClawer() {
			ICElement p = parent;
			while (p.getClawer() == null) {
				p = p.getParent();
			}
			return p.getClawer();
		}
		
		@Override
		public abstract void toJson(StringBuilder sb);
		
		@Override
		public abstract void toJson(int indent, StringBuilder sb);
		
		@Override
		public abstract void toMap(MapArrayHolder holder);
		
		protected void jsonName(String name, StringBuilder sb) {
			sb.append('"').append(name).append('"').append(':');
		}
		
		protected void jsonValue(Object value, StringBuilder sb) {
			if (value instanceof String) {
				sb.append('"').append(value).append('"');
			} else {
				sb.append(value);
			}
		}
		
		protected void jsonIndent(int indent, StringBuilder sb) {
			for (int i = 0; i < indent; i++) {
				sb.append("  ");
			}
		}
		
		protected void jsonElementSeparator(StringBuilder sb) {
			sb.append(',');
		}

		protected void jsonCRLF(StringBuilder sb) {
			sb.append('\r').append('\n');
		}
		
		protected void mapNameValue(String name, Object value, MapArrayHolder holder) {
			holder.putMap(name, value);
		}
		
		protected void mapNameObject(String name, Map<String, Object> map, MapArrayHolder holder) {
			holder.putMap(name, map);
		}
		
		protected void mapNameArray(String name, List<Object> array, MapArrayHolder holder) {
			holder.putMap(name, array);
		}
		
		protected void arrayValue(Object value, MapArrayHolder holder) {
			holder.putArray(value);
		}
		
		protected void arrayObject(Map<String, Object> map, MapArrayHolder holder) {
			holder.putArray(map);
		}
	}
	
	public static abstract class AbstractCElement extends AbstractElement implements ICElement {
		
		private ElementList elementList;
		protected Clawer clawer;
		
		protected AbstractCElement(ICElement parent, String path) {
			super(parent, path);
			elementList = new ElementList();
			initClawer();
		}
		
		@Override
		public Clawer getClawer() {
			if (clawer != null) {
				return clawer;
			}
			return super.getClawer();
		}
		
		@Override
		public void addChild(IElement element) {
			elementList.add(element);
		}
		
		@Override
		public ElementList getChildren() {
			return elementList;
		}
		
		protected void initClawer() {
			if (clawer == null && path != null) {
				clawer = super.getClawer().getClawer(path);
			}
		}
		
		protected void jsonObjectBegin(StringBuilder sb) {
			sb.append('{');
		}
		
		protected void jsonObjectEnd(StringBuilder sb) {
			sb.append('}');
		}
		
		protected void jsonArrayBegin(StringBuilder sb) {
			sb.append('[');
		}
		
		protected void jsonArrayEnd(StringBuilder sb) {
			sb.append(']');
		}
		
		protected void jsonObjectChildren(StringBuilder sb) {
			if (!elementList.isEmpty()) {
				for (IElement element : elementList) {
					element.toJson(sb);
					jsonElementSeparator(sb);
				}
				sb.setLength(sb.length() - 1);
			}
		}
		
		protected void jsonObjectChildren(int indent, StringBuilder sb) {
			if (!elementList.isEmpty()) {
				for (IElement element : elementList) {
					element.toJson(indent, sb);
					jsonElementSeparator(sb);
					jsonCRLF(sb);
				}
				sb.setLength(sb.length() - 3);
			}
		}
		
		protected void jsonArrayChildren(StringBuilder sb) {
			Clawer clawer = getClawer();
			if (clawer.getSelf() instanceof List<?>) {
				List<?> list = clawer.getSelf();
				IElement element = elementList.get(0);
				IItemValue itemValue = element instanceof IItemValue ? (IItemValue)element : null;
				IItemObject itemObject = element instanceof IItemObject ? (IItemObject)element : null;
				for (int i = 0, size = list.size(); i < size; i++) {
					if (itemValue != null) {
						itemValue.updateIndex(i);
						itemValue.toJson(sb);
						jsonElementSeparator(sb);
					} else if (itemObject != null) {
						itemObject.updateIndex(i);
						itemObject.updateClawer();
						itemObject.toJson(sb);
						jsonElementSeparator(sb);
					}
				}
				if (itemValue != null || itemObject != null) {
					sb.setLength(sb.length() - 1);
				}
			} else {
				if (!elementList.isEmpty()) {
					for (IElement element : elementList) {
						element.toJson(sb);
						jsonElementSeparator(sb);
					}
					sb.setLength(sb.length() - 1);
				}
			}
		}
		
		protected void jsonArrayChildren(int indent, StringBuilder sb) {
			Clawer clawer = getClawer();
			if (clawer.getSelf() instanceof List<?>) {
				List<?> list = clawer.getSelf();
				IElement element = elementList.get(0);
				IItemValue itemValue = element instanceof IItemValue ? (IItemValue)element : null;
				IItemObject itemObject = element instanceof IItemObject ? (IItemObject)element : null;
				for (int i = 0, size = list.size(); i < size; i++) {
					if (itemValue != null) {
						itemValue.updateIndex(i);
						itemValue.toJson(indent, sb);
						jsonElementSeparator(sb);
						jsonCRLF(sb);
					} else if (itemObject != null) {
						itemObject.updateIndex(i);
						itemObject.updateClawer();
						itemObject.toJson(indent, sb);
						jsonElementSeparator(sb);
						jsonCRLF(sb);
					}
				}
				if (itemValue != null || itemObject != null) {
					sb.setLength(sb.length() - 3);
				}
			} else {
				if (!elementList.isEmpty()) {
					for (IElement element : elementList) {
						element.toJson(indent, sb);
						jsonElementSeparator(sb);
						jsonCRLF(sb);
					}
					sb.setLength(sb.length() - 3);
				}
			}
		}
		
		protected void mapObjectChildren(MapArrayHolder holder) {
			if (!elementList.isEmpty()) {
				for (IElement element : elementList) {
					element.toMap(holder);
				}
			}
		}
		
		protected void mapArrayChildren(MapArrayHolder holder) {
			Clawer clawer = getClawer();
			if (clawer.getSelf() instanceof List<?>) {
				List<?> list = clawer.getSelf();
				IElement element = elementList.get(0);
				IItemValue itemValue = element instanceof IItemValue ? (IItemValue)element : null;
				IItemObject itemObject = element instanceof IItemObject ? (IItemObject)element : null;
				for (int i = 0, size = list.size(); i < size; i++) {
					if (itemValue != null) {
						itemValue.updateIndex(i);
						itemValue.toMap(holder);
					} else if (itemObject != null) {
						itemObject.updateIndex(i);
						itemObject.updateClawer();
						itemObject.toMap(holder);
					}
				}
			} else {
				if (!elementList.isEmpty()) {
					for (IElement element : elementList) {
						element.toMap(holder);
					}
				}
			}
		}
	}
	
	public static class KeyValue extends AbstractElement implements IKeyValue {

		private String name;
		
		public KeyValue(ICElement parent, String name, String path) {
			super(parent, path);
			this.name = name;
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public void toJson(StringBuilder sb) {
			jsonName(name, sb);
			jsonValue(getClawer().getValue(path), sb);
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			toJson(sb);
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			mapNameValue(name, getClawer().getValue(path), holder);
		}
	}
	
	public static class KeyObject extends AbstractCElement implements IKeyObject {

		private String name;
		
		public KeyObject(ICElement parent, String name, String path) {
			super(parent, path);
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void toJson(StringBuilder sb) {
			jsonName(name, sb);
			jsonObjectBegin(sb);
			jsonObjectChildren(sb);
			jsonObjectEnd(sb);
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			jsonName(name, sb);
			jsonObjectBegin(sb);
			jsonCRLF(sb);
			jsonObjectChildren(indent + 1, sb);
			jsonCRLF(sb);
			jsonIndent(indent, sb);
			jsonObjectEnd(sb);
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			Map<String, Object> map = new HashMap<>();
			mapNameObject(name, map, holder);
			mapObjectChildren(new MapArrayHolder(map));
		}
	}
	
	public static class KeyArray extends AbstractCElement implements IKeyArray {

		private String name;
		
		protected KeyArray(ICElement parent, String name, String path) {
			super(parent, path);
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void toJson(StringBuilder sb) {
			jsonName(name, sb);
			jsonArrayBegin(sb);
			jsonArrayChildren(sb);
			jsonArrayEnd(sb);
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			jsonName(name, sb);
			jsonArrayBegin(sb);
			jsonCRLF(sb);
			jsonArrayChildren(indent + 1, sb);
			jsonCRLF(sb);
			jsonIndent(indent, sb);
			jsonArrayEnd(sb);
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			List<Object> array = new ArrayList<>();
			mapNameArray(name, array, holder);
			mapArrayChildren(new MapArrayHolder(array));
		}
	}
	
	public static class ItemValue extends AbstractElement implements IItemValue {

		private Integer index;
		
		protected ItemValue(ICElement parent, String path) {
			super(parent, path);
		}
		
		@Override
		public Integer getIndex() {
			return index;
		}
		
		@Override
		public void updateIndex(Integer index) {
			this.index = index;
		}

		@Override
		public void toJson(StringBuilder sb) {
			Clawer clawer = getClawer();
			if (index != null) {
				jsonValue(clawer.getValue(clawer.getIndexFlag() + index + (path != null ? "{}." + path : "<>")), sb);
			} else {
				jsonValue(clawer.getValue(path), sb);
			}
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			toJson(sb);
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			Clawer clawer = getClawer();
			if (index != null) {
				arrayValue(clawer.getValue(clawer.getIndexFlag() + index + (path != null ? "{}." + path : "<>")), holder);
			} else {
				arrayValue(clawer.getValue(path), holder);
			}
		}
	}
	
	public static class ItemObject extends AbstractCElement implements IItemObject {

		private Integer index;
		
		protected ItemObject(ICElement parent, String path) {
			super(parent, path);
		}

		@Override
		public Integer getIndex() {
			return index;
		}
		
		@Override
		public void updateIndex(Integer index) {
			this.index = index;
		}
		
		@Override
		public void updateClawer() {
			reInitClawer();
		}
		
		@Override
		public void toJson(StringBuilder sb) {
			jsonObjectBegin(sb);
			jsonObjectChildren(sb);
			jsonObjectEnd(sb);
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			jsonObjectBegin(sb);
			jsonCRLF(sb);
			jsonObjectChildren(indent + 1, sb);
			jsonCRLF(sb);
			jsonIndent(indent, sb);
			jsonObjectEnd(sb);
		}
		
		protected void reInitClawer() {
			if (index != null) {
				clawer = null;
				Clawer pclawer = getClawer();
				clawer = pclawer.getClawer(pclawer.getIndexFlag() + index + "{}" + (path != null ? "." + path : ""));
			}
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			Map<String, Object> map = new HashMap<>();
			arrayObject(map, holder);
			mapObjectChildren(new MapArrayHolder(map));
		}
	}
	
	public static class Root extends AbstractCElement implements IRoot {

		public Root(Clawer clawer) {
			super(null, null);
			this.clawer = clawer;
		}

		@Override
		public void toJson(StringBuilder sb) {
			jsonObjectBegin(sb);
			jsonObjectChildren(sb);
			jsonObjectEnd(sb);
		}

		@Override
		public void toJson(int indent, StringBuilder sb) {
			jsonIndent(indent, sb);
			jsonObjectBegin(sb);
			jsonCRLF(sb);
			jsonObjectChildren(indent + 1, sb);
			jsonCRLF(sb);
			jsonIndent(indent, sb);
			jsonObjectEnd(sb);
		}
		
		@Override
		public void toMap(MapArrayHolder holder) {
			mapObjectChildren(holder);
		}
	}
	
	public static class ElementList extends ArrayList<IElement> {

		private static final long serialVersionUID = 2966834684665318643L;
		
	}
	
	public static class MapArrayHolder {
		
		private Map<String, Object> map;
		private List<Object> array;
		
		public MapArrayHolder(Map<String, Object> map) {
			this.map = map;
		}
		
		public MapArrayHolder(List<Object> array) {
			this.array = array;
		}
		
		public void putMap(String name, Object value) {
			map.put(name, value);
		}
		
		public void putArray(Object value) {
			array.add(value);
		}
	}
}
