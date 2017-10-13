package org.eop.java.cchelper;

import java.util.ArrayList;

/**
 * @author lixinjie
 * @since 2017-09-23
 */
public class Clawer {
	
	private IElement<?> rootElement;
	private IElement<?> currElement;
	private INodeAnalyzer nodeAnalyzer;
	
	private Clawer(IElement<?> rootElement) {
		this(rootElement, ".", "#");
	}
	
	private Clawer(IElement<?> rootElement, String delimiter, String indexFlag) {
		this.rootElement = rootElement;
		this.nodeAnalyzer = new DefaultNodeAnalyzer(delimiter, indexFlag);
	}
	
	public static Clawer fromMap(java.util.Map<String, Object> data) {
		return fromElement(new MapObject(data));
	}
	
	public static Clawer fromMap(java.util.List<java.util.Map<String, Object>> datas) {
		return fromElement(new MapArray(datas));
	}
	
	public static Clawer fromFastJson(com.alibaba.fastjson.JSONObject data) {
		return fromElement(new FastJsonObject(data));
	}
	
	public static Clawer fromFastJson(com.alibaba.fastjson.JSONArray datas) {
		return fromElement(new FastJsonArray(datas));
	}
	
	public static Clawer fromNetsfJson(net.sf.json.JSONObject data) {
		return fromElement(new NetsfJsonObject(data));
	}
	
	public static Clawer fromNetsfJson(net.sf.json.JSONArray datas) {
		return fromElement(new NetsfJsonArray(datas));
	}
	
	protected static Clawer fromElement(IElement<?> element) {
		return new Clawer(element);
	}
	
	public Clawer delimiter(String delimiter) {
		nodeAnalyzer.setDelimiter(delimiter);
		return this;
	}
	
	public Clawer indexFlag(String indexFlag) {
		nodeAnalyzer.setIndexFlag(indexFlag);
		return this;
	}
	
	public String getDelimiter() {
		return nodeAnalyzer.getDelimiter();
	}
	
	public String getIndexFlag() {
		return nodeAnalyzer.getIndexFlag();
	}
	
	
	public Clawer getClawer(String path) {
		clawerElement(path);
		return fromElement(currElement)
				.delimiter(getDelimiter())
				.indexFlag(getIndexFlag());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getSelf() {
		return (T)rootElement.getSelf();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(String path) {
		clawerElement(path);
		return (T)currElement.getSelf();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getArray(String path) {
		clawerElement(path);
		return (T)currElement.getSelf();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getValue(String path) {
		clawerElement(path);
		return (T)currElement.getSelf();
	}
	
	
	protected void clawerElement(String path) {
		NodeList nodeList = nodeAnalyzer.analyze(path);
		currElement = rootElement;
		for (INode node : nodeList) {
			currElement = currElement.getNext(node);
		}
	}

	public interface IElement<T> {
		
		IElement<?> getNext(INode node);
		
		T getSelf();
	}
	
	public interface IObject<T> extends IElement<T> {
		
		IObject<?> getObject(String name);
		
		IArray<?> getArray(String name);
		
		IValue<?> getValue(String name);
	}
	
	public interface IArray<T> extends IElement<T> {
		
		IObject<?> getObject(Integer index);
		
		IValue<?> getValue(Integer index);
	}
	
	public interface IValue<T> extends IElement<T> {
		
	}
	
	public static abstract class AbstractElement<T> implements IElement<T> {
		
		protected T self;
		
		protected AbstractElement(T self) {
			this.self = self;
		}
		
		@Override
		public IElement<?> getNext(INode node) {
			if (node.getNodeType() == NodeType.IndexNode) {
				return getNextElement((IIndexNode)node);
			} else if (node.getNodeType() == NodeType.NameNode) {
				return getNextElement((INameNode)node);
			}
			return null;
		}
		
		protected IElement<?> getNextElement(IIndexNode node) {
			if (node.getElementType() == ElementType.Object) {
				return getNextObjectByIndex(node.getIndex());
			}else if (node.getElementType() == ElementType.Value) {
				return getNextValueByIndex(node.getIndex());
			}
			return null;
		}
		
		protected IElement<?> getNextElement(INameNode node) {
			if (node.getElementType() == ElementType.Object) {
				return getNextObjectByName(node.getName());
			} else if (node.getElementType() == ElementType.Array) {
				return getNextArrayByName(node.getName());
			} else if (node.getElementType() == ElementType.Value) {
				return getNextValueByName(node.getName());
			}
			return null;
		}
		
		protected abstract IElement<?> getNextObjectByIndex(Integer index);
		
		protected abstract IElement<?> getNextValueByIndex(Integer index);
		
		protected abstract IElement<?> getNextObjectByName(String name);
		
		protected abstract IElement<?> getNextArrayByName(String name);
		
		protected abstract IElement<?> getNextValueByName(String name);
		
		@Override
		public T getSelf() {
			return self;
		}
	}
	
	public static abstract class AbstractObject<T> extends AbstractElement<T> implements IObject<T> {
		
		protected AbstractObject(T self) {
			super(self);
		}
		
		@Override
		protected IElement<?> getNextObjectByIndex(Integer index) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextValueByIndex(Integer index) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextObjectByName(String name) {
			return getObject(name);
		}
		
		@Override
		protected IElement<?> getNextArrayByName(String name) {
			return getArray(name);
		}
		
		@Override
		protected IElement<?> getNextValueByName(String name) {
			return getValue(name);
		}
		
	}
	
	public static abstract class AbstractArray<T> extends AbstractElement<T> implements IArray<T> {
		
		protected AbstractArray(T self) {
			super(self);
		}
		
		@Override
		protected IElement<?> getNextObjectByIndex(Integer index) {
			return getObject(index);
		}
		
		@Override
		protected IElement<?> getNextValueByIndex(Integer index) {
			return getValue(index);
		}
		
		@Override
		protected IElement<?> getNextObjectByName(String name) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextArrayByName(String name) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextValueByName(String name) {
			return null;
		}
		
	}
	
	public static class Value<T> extends AbstractElement<T> implements IValue<T> {
		
		public Value(T self) {
			super(self);
		}
		
		@Override
		protected IElement<?> getNextObjectByIndex(Integer index) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextValueByIndex(Integer index) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextObjectByName(String name) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextArrayByName(String name) {
			return null;
		}
		
		@Override
		protected IElement<?> getNextValueByName(String name) {
			return null;
		}
		
	}
	
	public static class MapObject extends AbstractObject<java.util.Map<String, Object>> {

		public MapObject(java.util.Map<String, Object> self) {
			super(self);
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public IObject<?> getObject(String name) {
			return new MapObject((java.util.Map<String, Object>)self.get(name));
		}

		@SuppressWarnings("unchecked")
		@Override
		public IArray<?> getArray(String name) {
			return new MapArray((java.util.List<java.util.Map<String, Object>>)self.get(name));
		}

		@Override
		public IValue<?> getValue(String name) {
			return new Value<Object>(self.get(name));
		}
		
	}
	
	public static class MapArray extends AbstractArray<java.util.List<java.util.Map<String, Object>>> {

		public MapArray(java.util.List<java.util.Map<String, Object>> self) {
			super(self);
		}
		
		@Override
		public IObject<?> getObject(Integer index) {
			return new MapObject(self.get(IndexUtils.transformIndex(index, self.size())));
		}

		@Override
		public IValue<?> getValue(Integer index) {
			return new Value<Object>(self.get(IndexUtils.transformIndex(index, self.size())));
		}
		
	}
	
	public static class FastJsonObject extends AbstractObject<com.alibaba.fastjson.JSONObject> {

		public FastJsonObject(com.alibaba.fastjson.JSONObject self) {
			super(self);
		}
		
		@Override
		public IObject<?> getObject(String name) {
			return new FastJsonObject(self.getJSONObject(name));
		}

		@Override
		public IArray<?> getArray(String name) {
			return new FastJsonArray(self.getJSONArray(name));
		}

		@Override
		public IValue<?> getValue(String name) {
			return new Value<Object>(self.get(name));
		}
		
	}
	
	public static class FastJsonArray extends AbstractArray<com.alibaba.fastjson.JSONArray> {

		public FastJsonArray(com.alibaba.fastjson.JSONArray self) {
			super(self);
		}
		
		@Override
		public IObject<?> getObject(Integer index) {
			return new FastJsonObject(self.getJSONObject(IndexUtils.transformIndex(index, self.size())));
		}

		@Override
		public IValue<?> getValue(Integer index) {
			return new Value<Object>(self.get(IndexUtils.transformIndex(index, self.size())));
		}
		
	}
	
	public static class NetsfJsonObject extends AbstractObject<net.sf.json.JSONObject> {

		public NetsfJsonObject(net.sf.json.JSONObject self) {
			super(self);
		}
		
		@Override
		public IObject<?> getObject(String name) {
			return new NetsfJsonObject(self.getJSONObject(name));
		}

		@Override
		public IArray<?> getArray(String name) {
			return new NetsfJsonArray(self.getJSONArray(name));
		}

		@Override
		public IValue<?> getValue(String name) {
			return new Value<Object>(self.get(name));
		}
		
	}
	
	public static class NetsfJsonArray extends AbstractArray<net.sf.json.JSONArray> {

		public NetsfJsonArray(net.sf.json.JSONArray self) {
			super(self);
		}
		
		@Override
		public IObject<?> getObject(Integer index) {
			return new NetsfJsonObject(self.getJSONObject(IndexUtils.transformIndex(index, self.size())));
		}

		@Override
		public IValue<?> getValue(Integer index) {
			return new Value<Object>(self.get(IndexUtils.transformIndex(index, self.size())));
		}
		
	}
	
	public enum ElementType {
		Object,
		Array,
		Value
	}
	
	public enum NodeType {
		NameNode,
		IndexNode
	}
	
	
	public interface INode {
		
		ElementType getElementType();
		
		NodeType getNodeType();
	}
	
	public interface INameNode extends INode {
		
		String getName();
	}
	
	public interface IIndexNode extends INode {
		
		Integer getIndex();
	}
	
	public static abstract class AbstractNode implements INode {
		
		private ElementType elementType;
		private NodeType nodeType;
		
		protected AbstractNode(ElementType elementType, NodeType nodeType) {
			this.elementType = elementType;
			this.nodeType = nodeType;
		}
		
		@Override
		public ElementType getElementType() {
			return elementType;
		}
		
		@Override
		public NodeType getNodeType() {
			return nodeType;
		}
		
	}
	
	public static class NameNode extends AbstractNode implements INameNode {

		private String name;
		
		protected NameNode(String name, ElementType elementType) {
			super(elementType, NodeType.NameNode);
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
		
	}
	
	public static class IndexNode extends AbstractNode implements IIndexNode {

		private Integer index;
		
		protected IndexNode(Integer index, ElementType elementType) {
			super(elementType, NodeType.IndexNode);
			this.index = index;
		}

		@Override
		public Integer getIndex() {
			return index;
		}
		
	}
	
	public static class NodeList extends ArrayList<INode> {

		private static final long serialVersionUID = -267151465789978269L;
		
	}
	
	public interface INodeAnalyzer {
		
		NodeList analyze(String path);
		
		String getDelimiter();
		
		void setDelimiter(String delimiter);
		
		String getIndexFlag();
		
		void setIndexFlag(String indexFlag);
	}
	
	public static class DefaultNodeAnalyzer implements INodeAnalyzer {

		private String delimiter;
		private String indexFlag;
		
		public DefaultNodeAnalyzer(String delimiter, String indexFlag) {
			this.delimiter = delimiter;
			this.indexFlag = indexFlag;
		}
		
		@Override
		public NodeList analyze(String path) {
			NodeList nodeList = new NodeList();
			String[] parts = StringUtils.split(path, delimiter);
			for (String part : parts) {
				String name = StringUtils.getLeft(part, -3);
				String type = StringUtils.getRight(part, -2);
				nodeList.add(analyzeNode(name, type));
			}
			return nodeList;
		}
		
		protected INode analyzeNode(String name, String type) {
			if (isIndexNode(name)) {
				return new IndexNode(getIndex(name), getElementType(type));
			} else {
				return new NameNode(name, getElementType(type));
			}
		}
		
		protected boolean isIndexNode(String name) {
			return name.startsWith(indexFlag);
		}
		
		protected Integer getIndex(String name) {
			return Integer.valueOf(StringUtils.getRight(name, 1));
		}
		
		protected ElementType getElementType(String type) {
			switch (type) {
				case "{}": return ElementType.Object;
				case "[]": return ElementType.Array;
				case "<>": return ElementType.Value;
				default : return null;
			}
		}

		@Override
		public String getDelimiter() {
			return delimiter;
		}
		
		@Override
		public void setDelimiter(String delimiter) {
			this.delimiter = delimiter;
		}

		@Override
		public String getIndexFlag() {
			return indexFlag;
		}
		
		@Override
		public void setIndexFlag(String indexFlag) {
			this.indexFlag = indexFlag;
		}
	}
	
	public static class StringUtils {
		
		public static String[] split(String str, String delimiter) {
			return str.split("[" + delimiter + "]");
		}
		
		public static String getLeft(String str, int end) {
			return getSubstr(str, 0, end);
		}
		
		public static String getRight(String str, int begin) {
			return getSubstr(str, begin, -1);
		}
		
		public static String getSubstr(String str, int begin, int end) {
			return str.substring(IndexUtils.transformIndex(begin, str.length()), IndexUtils.transformIndex(end, str.length(), 1));
		}
	}
	
	public static class IndexUtils {
		
		public static int transformIndex(int index, int size) {
			return transformIndex(index, size, 0);
		}
		
		public static int transformIndex(int index, int size, int delta) {
			if (index >= 0) {
				return index;
			}
			return index + size + delta;
		}
	}
}
