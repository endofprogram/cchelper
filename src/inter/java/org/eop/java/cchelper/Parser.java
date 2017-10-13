package org.eop.java.cchelper;

import java.util.HashMap;

/**
 * @author lixinjie
 * @since 2017-09-24
 */
public class Parser {

	private BuilderCache builderCache;
	private String template;
	private String prefixFlag;
	private Clawer clawer;
	
	private Parser(String template, Clawer clawer) {
		this(template, "#", clawer);
	}
	
	private Parser(String template, String prefixFlag, Clawer clawer) {
		initTemplate(template);
		this.prefixFlag = prefixFlag;
		this.clawer = clawer;
		builderCache = new BuilderCache();
		initBuilderCache();
	}
	
	public static Parser from(String template, Clawer clawer) {
		return new Parser(template, clawer);
	}
	
	public Parser prefixFlag(String prefixFlag) {
		this.prefixFlag = prefixFlag;
		return this;
	}
	
	public Builder build() {
		Builder builder = Builder.from(clawer);
		String[] parts = splitTemplate();
		for (String part : parts) {
			builderCache.get(getDirective(part)).build(builder, getElement(part));
		}
		return builder;
	}
	
	protected String getDirective(String part) {
		return StringUtils.getLeft(part, 2);
	}
	
	protected String getElement(String part) {
		if (part.length() < 5) {
			return null;
		}
		return StringUtils.getRight(part, 2);
	}
	
	protected String[] splitTemplate() {
		return StringUtils.split(StringUtils.getRight(template, 1), prefixFlag);
	}
	
	protected void initTemplate(String template) {
		this.template = template.trim().replace("\r", "").replace("\n", "")
										.replace(" ", "").replace("\t", "");
	}
	
	protected void initBuilderCache() {
		builderCache.put("kv", new KVBuilder());
		builderCache.put("ko", new KOBuilder());
		builderCache.put("ok", new OKBuilder());
		builderCache.put("ka", new KABuilder());
		builderCache.put("ak", new AKBuilder());
		builderCache.put("iv", new IVBuilder());
		builderCache.put("io", new IOBuilder());
		builderCache.put("oi", new OIBuilder());
	}
	
	public interface IBuilder {
		
		void build(Builder builder, String element);
	}
	
	public static abstract class AbstractBuilder implements IBuilder {
		
		@Override
		public abstract void build(Builder builder, String element);
		
		protected String getName(String element) {
			if (element == null || element.isEmpty()) {
				return null;
			}
			String elem = StringUtils.getSubstr(element.trim(), 1, -2);
			String[] elems = StringUtils.split(elem, ",");
			if (elems.length > 0) {
				return elems[0].trim();
			}
			return null;
		}
		
		protected String getPath(String element) {
			if (element == null || element.isEmpty()) {
				return null;
			}
			String elem = StringUtils.getSubstr(element.trim(), 1, -2);
			String[] elems = StringUtils.split(elem, ",");
			if (elems.length > 1) {
				return elems[1].trim();
			}
			return null;
		}
	}
	
	public static class KVBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.kv(getName(element), getPath(element));
		}
		
	}
	
	public static class KOBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.ko(getName(element), getPath(element));
		}
		
	}
	
	public static class OKBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.end();
		}
		
	}
	
	public static class KABuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.ka(getName(element), getPath(element));
		}
		
	}
	
	public static class AKBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.end();
		}
		
	}
	
	public static class IVBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.iv(getName(element));
		}
		
	}
	
	public static class IOBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.io(getName(element));
		}
		
	}
	
	public static class OIBuilder extends AbstractBuilder {

		@Override
		public void build(Builder builder, String element) {
			builder.end();
		}
		
	}
	
	public static class BuilderCache extends HashMap<String, IBuilder> {

		private static final long serialVersionUID = -4198786720574014799L;
		
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
