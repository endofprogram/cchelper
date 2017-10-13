package org.eop.groovy.cchelper.test.sql

/**
 * @author lixinjie
 */
class InterParamMain {

	static main(args) {
		println '-----------------------接入接口参数-----------------------'
		inParam()
		println '-----------------------转接接口参数-----------------------'
		outParam()
		println '-----------------------接口参数映射-----------------------'
		paramMapping()
	}
	
	static void inParam() {
		inMapper.eachWithIndex{entity, index ->
			println """list << [type:'1', name:'$entity.key', nflag:'0', seqno:'${index + 1}']"""
		}
		println ''
		outMapper.eachWithIndex{entity, index ->
			println """list << [type:'2', name:'$entity.key', nflag:'1', seqno:'${index + 101}']"""
		}
	}
	
	static void outParam() {
		inMapper.eachWithIndex{entity, index ->
			println """list << [type:'1', name:'$entity.value', nflag:'1', seqno:'${index + 1}']"""
		}
		println ''
		outMapper.eachWithIndex{entity, index ->
			println """list << [type:'2', name:'$entity.value', nflag:'1', seqno:'${index + 101}']"""
		}
	}
	
	static void paramMapping() {
		inMapper.each{entity ->
			println """list << [name1:'$entity.key', name2:'$entity.value', type:'1']"""
		}
		println ''
		outMapper.each{entity ->
			println """list << [name1:'$entity.key', name2:'$entity.value', type:'2']"""
		}
	}

	static Map getInMapper() {
		['userMobile':'BMobile', 'startRowNum':'SRowNum', 'endRowNum':'ERowNum']
	}
	
	static Map getOutMapper() {
		[:]
	}
}
