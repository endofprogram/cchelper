package org.eop.groovy.cchelper.test.sql.migu

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _31Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\咪咕公司接口\\数据库\\测试环境\\', name:'31业务查询服务请求派发']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'咪咕公司', desc:'咪咕公司', prov:'migu', code:'MIGU']
	}

	@Override
	Map getChannel() {
		[name:'咪咕公司', addr:'http://218.206.190.10:7701']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'DualMicro', fst:'Secret', sec:'secretType', val:'off', rmk:'双微加密类型']
		list << [type:'DualMicro', fst:'Secret', sec:'secretKey', val:'eddd62cbbe9a3424857a968cd8c356fe', rmk:'双微加密密钥']
		list << [type:'DualMicro', fst:'Secret', sec:'secretAddr', val:'', rmk:'双微加密机地址']
		list << [type:'DualMicro', fst:'Secret', sec:'secretPort', val:'', rmk:'双微加密机端口']
		list
	}

	@Override
	Map getInInterface() {
		[route:'', name:'咪咕公司_查询_业务查询服务请求派发', clsnm:'miguIntfService', type:'', path:'business/migu/busiQry', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'咪咕公司_查询_业务查询服务请求派发(20170606_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'网状网_查询_业务查询服务请求派发', clsnm:'miguCommonService', type:'', path:'/Trans/Receiver', bizcode:'', method:'POST', fmttype:'xml', entid:'10', desc:'网状网_查询_业务查询服务请求派发(20170606_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'indictSeq', nflag:'0', seqno:'1']
		list << [type:'1', name:'callerNo', nflag:'1', seqno:'2']
		list << [type:'1', name:'calledNo', nflag:'1', seqno:'3']
		list << [type:'1', name:'subsName', nflag:'1', seqno:'4']
		list << [type:'1', name:'subsLevel', nflag:'1', seqno:'5']
		list << [type:'1', name:'subsBrand', nflag:'1', seqno:'6']
		list << [type:'1', name:'svcTypeId', nflag:'0', seqno:'7']
		list << [type:'1', name:'homeProv', nflag:'0', seqno:'8']
		list << [type:'1', name:'svcCity', nflag:'0', seqno:'9']
		list << [type:'1', name:'originTime', nflag:'0', seqno:'10']
		list << [type:'1', name:'acceptTime', nflag:'0', seqno:'11']
		list << [type:'1', name:'acceptStaff', nflag:'1', seqno:'12']
		list << [type:'1', name:'contactChannel', nflag:'0', seqno:'13']
		list << [type:'1', name:'serviceTypeId', nflag:'0', seqno:'14']
		list << [type:'1', name:'operateTypeId', nflag:'0', seqno:'15']
		list << [type:'1', name:'operateConditions', nflag:'0', seqno:'16']
		
		list << [type:'2', name:'operRtnStaId', nflag:'1', seqno:'101']
		list << [type:'2', name:'rsltTotalCnt', nflag:'1', seqno:'102']
		list << [type:'2', name:'rsltPageMaxCnt', nflag:'1', seqno:'103']
		list << [type:'2', name:'rsltPageCurrCnt', nflag:'1', seqno:'104']
		list << [type:'2', name:'rsltPageNum', nflag:'1', seqno:'105']
		list << [type:'2', name:'rsltTotalPages', nflag:'1', seqno:'106']
		list << [type:'2', name:'qryRsltList', nflag:'1', seqno:'107']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'IndictSeq', nflag:'1', seqno:'1']
		list << [type:'1', name:'CallerNo', nflag:'1', seqno:'2']
		list << [type:'1', name:'CalledNo', nflag:'1', seqno:'3']
		list << [type:'1', name:'SubsName', nflag:'1', seqno:'4']
		list << [type:'1', name:'SubsLevel', nflag:'1', seqno:'5']
		list << [type:'1', name:'SubsBrand', nflag:'1', seqno:'6']
		list << [type:'1', name:'SvcTypeId', nflag:'1', seqno:'7']
		list << [type:'1', name:'HomeProv', nflag:'1', seqno:'8']
		list << [type:'1', name:'SvcCity', nflag:'1', seqno:'9']
		list << [type:'1', name:'OriginTime', nflag:'1', seqno:'10']
		list << [type:'1', name:'AcceptTime', nflag:'1', seqno:'11']
		list << [type:'1', name:'AcceptStaff', nflag:'1', seqno:'12']
		list << [type:'1', name:'ContactChannel', nflag:'1', seqno:'13']
		list << [type:'1', name:'ServiceTypeId', nflag:'1', seqno:'14']
		list << [type:'1', name:'OperateTypeId', nflag:'1', seqno:'15']
		list << [type:'1', name:'OperateConditions', nflag:'1', seqno:'16']
		
		list << [type:'2', name:'OperRtnStaId', nflag:'1', seqno:'101']
		list << [type:'2', name:'RsltTotalCnt', nflag:'1', seqno:'102']
		list << [type:'2', name:'RsltPageMaxCnt', nflag:'1', seqno:'103']
		list << [type:'2', name:'RsltPageCurrCnt', nflag:'1', seqno:'104']
		list << [type:'2', name:'RsltPageNum', nflag:'1', seqno:'105']
		list << [type:'2', name:'RsltTotalPages', nflag:'1', seqno:'106']
		list << [type:'2', name:'QryRsltList', nflag:'1', seqno:'107']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'indictSeq', name2:'IndictSeq', type:'1']
		list << [name1:'callerNo', name2:'CallerNo', type:'1']
		list << [name1:'calledNo', name2:'CalledNo', type:'1']
		list << [name1:'subsName', name2:'SubsName', type:'1']
		list << [name1:'subsLevel', name2:'SubsLevel', type:'1']
		list << [name1:'subsBrand', name2:'SubsBrand', type:'1']
		list << [name1:'svcTypeId', name2:'SvcTypeId', type:'1']
		list << [name1:'homeProv', name2:'HomeProv', type:'1']
		list << [name1:'svcCity', name2:'SvcCity', type:'1']
		list << [name1:'originTime', name2:'OriginTime', type:'1']
		list << [name1:'acceptTime', name2:'AcceptTime', type:'1']
		list << [name1:'acceptStaff', name2:'AcceptStaff', type:'1']
		list << [name1:'contactChannel', name2:'ContactChannel', type:'1']
		list << [name1:'serviceTypeId', name2:'ServiceTypeId', type:'1']
		list << [name1:'operateTypeId', name2:'OperateTypeId', type:'1']
		list << [name1:'operateConditions', name2:'OperateConditions', type:'1']
		
		list << [name1:'operRtnStaId', name2:'OperRtnStaId', type:'2']
		list << [name1:'rsltTotalCnt', name2:'RsltTotalCnt', type:'2']
		list << [name1:'rsltPageMaxCnt', name2:'RsltPageMaxCnt', type:'2']
		list << [name1:'rsltPageCurrCnt', name2:'RsltPageCurrCnt', type:'2']
		list << [name1:'rsltPageNum', name2:'RsltPageNum', type:'2']
		list << [name1:'rsltTotalPages', name2:'RsltTotalPages', type:'2']
		list << [name1:'qryRsltList', name2:'QryRsltList', type:'2']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'BIPCode', value:'BIP2C092', seqno:'01']
		list << [name:'ActivityCode', value:'T2002092', seqno:'02']
		list << [name:'reqRootElement', value:'SvcRoot', seqno:'03']
		list << [name:'provCodeSuccess', value:'0000', seqno:'04']
		list << [name:'resultCodeSuccess', value:'00000', seqno:'05']
		list << [name:'resultDescSuccess', value:'成功', seqno:'06']
		list << [name:'rpsTypeElement', value:'RspType', seqno:'04']
		list << [name:'rpsCodeElement', value:'RspCode', seqno:'05']
		list << [name:'rpsDescElement', value:'RspDesc', seqno:'06']
		
		list << [name:'1101_name', value:'咪咕阅读-业务黑名单用户查询', seqno:'030']
		list << [name:'1101_in_mapping', value:'1|userMobile,2|type', seqno:'031']
		list << [name:'1101_out_mapping', value:'1|recordNo,2|userMobile,3|shieldBusi,4|lastShieldDate', seqno:'031']
		
		list << [name:'1102_name', value:'咪咕阅读-阅读记录查询', seqno:'035']
		list << [name:'1102_in_mapping', value:'1|userMobile,2|readBeginTime,3|readEndTime,4|readApproach,5|contentType,6|bookName,7|chapterName', seqno:'036']
		list << [name:'1102_out_mapping', value:'1|recordNo,2|userMobile,3|bookName,4|volumeName,5|chapterName,6|contentType,7|readTime,8|orderWay,9|readApproach', seqno:'036']
		
		list << [name:'1103_name', value:'咪咕阅读-书籍信息查询', seqno:'40']
		list << [name:'1103_in_mapping', value:'1|bookItemName,2|mcpName,3|authorPenName', seqno:'41']
		list << [name:'1103_out_mapping', value:'1|recordNo,2|bookName,3|author,4|franchisor,5|recommendClass,6|worksLength,7|chargeDesc', seqno:'41']
		
		list << [name:'1104_name', value:'咪咕阅读-书卷(券)查询', seqno:'45']
		list << [name:'1104_in_mapping', value:'1|userMobile,2|couponName,3|couponId,4|consumeBeginTime,5|consumeEndTime', seqno:'46']
		list << [name:'1104_out_mapping', value:'1|recordNo,2|userMobile,3|couponId,4|couponName,5|fetchTime,6|consumeBeginTime,7|consumeEndTime,8|price,9|remainder,10|latestConsumeTime', seqno:'46']
		
		list << [name:'1105_name', value:'咪咕阅读-包月记录查询', seqno:'30']
		list << [name:'1105_in_mapping', value:'1|userMobile', seqno:'30']
		list << [name:'1105_out_mapping', value:'1|recordNo,2|userMobile,3|columnName,4|productId,5|productName,6|chargeDesc,7|orderTime,8|unorderTime,9|latestOrderApproach,10|status,11|suspendTime,12|resumeTime,13|channelId', seqno:'30']
		
		list << [name:'1106_name', value:'咪咕阅读-点播记录(订购)查询', seqno:'30']
		list << [name:'1106_in_mapping', value:'1|userMobile,2|bookName,3|orderBeginTime,4|orderEndTime,5|chargeWay,6|contentType,7|isDonate,8|orderApproach,9|chapterName', seqno:'30']
		list << [name:'1106_out_mapping_1', value:'1|recordNo,2|userMobile,3|name,4|volumeName,5|chapterName,6|orderTime,7|contentType,8|orderApproach,9|chargeDesc,10|chargeWay', seqno:'30']
		list << [name:'1106_out_mapping_2', value:'11|price,12|shouldPayAmount,13|couponDeduction,14|actualPayAmount,15|consumeWay,16|productId,17|donateFriend,18|friendMobile,19|channelId', seqno:'30']
		
		list << [name:'1108_name', value:'咪咕阅读-充值记录查询', seqno:'30']
		list << [name:'1108_in_mapping', value:'1|userMobile,2|rechargeBeginTime,3|rechargeEndTime,4|rechargeWay', seqno:'30']
		list << [name:'1108_out_mapping', value:'1|recordNo,2|serialNo,3|rechargeAmount,4|actualPayAmount,5|rechargeWay,6|rechargeStatus,7|rechargeTime', seqno:'30']
		
		list << [name:'1109_name', value:'咪咕阅读-短信上下行查询', seqno:'30']
		list << [name:'1109_in_mapping', value:'1|userMobile,2|sendBeginTime,3|sendEndTime,4|direction', seqno:'30']
		list << [name:'1109_out_mapping', value:'1|recordNo,2|userMobile,3|sendTime,4|taskName,5|type,6|messageContent', seqno:'30']
		
		list << [name:'1201_name', value:'咪咕阅读-业务黑名单用户添加或取消', seqno:'30']
		list << [name:'1201_in_mapping', value:'1|userMobile,2|shieldBusiness,3|operateType,4|operateStaffName,5|operateStaffId,6|provinceId', seqno:'30']
		list << [name:'1201_out_mapping', value:'', seqno:'30']
		
		
		
		list << [name:'2101_name', value:'咪咕游戏-黑名单查询', seqno:'']
		list << [name:'2101_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2101_out_mapping', value:'1|recordNo,2|userMobile,3|rosterLevel,4|rosterSource,5|createTime', seqno:'']
		
		list << [name:'2102_name', value:'咪咕游戏-消费记录查询', seqno:'']
		list << [name:'2102_in_mapping', value:'1|userMobile,2|beginTime,3|endTime,4|acceptType,5|acceptContent', seqno:'']
		list << [name:'2102_out_mapping', value:'1|recordNo,2|operateTime,3|userMobile,4|businessCode,5|businessName,6|businessType,7|packageName,8|payWay,9|partnerCode,10|partnerName,11|basicPrice,12|tackleCode,13|tackleName,14|chargeWay,15|actualCharge,16|discountStrategy', seqno:'']
		
		list << [name:'2103_name', value:'咪咕游戏-套餐订购关系查询', seqno:'']
		list << [name:'2103_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'2103_out_mapping', value:'1|recordNo,2|userId,3|packageOrderTime,4|packageId,5|packageName,6|channelId,7|channelName,8|orderWay,9|orderStatus', seqno:'']
		
		list << [name:'2104_name', value:'咪咕游戏-套餐订购记录查询', seqno:'']
		list << [name:'2104_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'2104_out_mapping', value:'1|recordNo,2|status,3|queryType,4|resultStatus,5|userType,6|userMobile,7|packageName,8|concreteOperation,9|channelId,10|packageId,11|channelName,12|moneyAmount,13|operateTime', seqno:'']
		
		list << [name:'2105_name', value:'咪咕游戏-点卡充值记录查询', seqno:'']
		list << [name:'2105_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'2105_out_mapping', value:'1|recordNo,2|operateTime,3|partnerCode,4|rechargeCode,5|moneyAmount,6|channelName,7|rechargeWay,8|refundFlag', seqno:'']
		
		list << [name:'2106_name', value:'咪咕游戏-点数余额查询', seqno:'']
		list << [name:'2106_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2106_out_mapping', value:'1|recordNo,2|type,3|resultStatus,4|userType,5|userMobile,6|pointCount', seqno:'']
		
		list << [name:'2107_name', value:'咪咕游戏-业务基本信息查询', seqno:'']
		list << [name:'2107_in_mapping', value:'1|businessName,2|businessCode,3|packageType', seqno:'']
		list << [name:'2107_out_mapping', value:'1|recordNo,2|businessCode,3|partnerCode,4|businessName,5|gameBusinessType,6|payType,7|chargeWay,8|gameBusinessStatus,9|effectiveDate,10|ineffectiveDate,11|packageId,12|businessPackageName,13|moneyAmount,14|chargeUnit', seqno:'']
		
		list << [name:'2108_name', value:'咪咕游戏-营销消息屏蔽查询', seqno:'']
		list << [name:'2108_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2108_out_mapping', value:'1|recordNo,2|userMobile,3|mobileNoSource,4|jointShieldTime', seqno:'']
		
		list << [name:'2109_name', value:'咪咕游戏-用户信息查询', seqno:'']
		list << [name:'2109_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2109_out_mapping', value:'1|registerTime,2|userPseudoNo,3|email,4|customAccount', seqno:'']
		
		list << [name:'2110_name', value:'咪咕游戏-灰名单查询', seqno:'']
		list << [name:'2110_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2110_out_mapping', value:'1|recordNo,2|userMobile,3|grayRosterSource,4|createTime', seqno:'']
		
		list << [name:'2111_name', value:'咪咕游戏-核查查询', seqno:'']
		list << [name:'2111_in_mapping', value:'1|operateDate,2|businessCode,3|userMobile', seqno:'']
		list << [name:'2111_out_mapping', value:'1|checkResult', seqno:'']
		
		list << [name:'2112_name', value:'咪咕游戏-使用记录查询', seqno:'']
		list << [name:'2112_in_mapping', value:'1|operateDate,2|businessCode,3|userMobile', seqno:'']
		list << [name:'2112_out_mapping', value:'1|businessCode,2|businessName,3|operateTime,4|operateType', seqno:'']
		
		list << [name:'2201_name', value:'咪咕游戏-黑名单新增', seqno:'']
		list << [name:'2201_in_mapping', value:'1|userMobile,2|rosterLevel,3|blackRosterSource,4|blackRosterAddWay', seqno:'']
		list << [name:'2201_out_mapping', value:'1|operateStatusReturnCode,2|operateProcessResultDesc', seqno:'']
		
		list << [name:'2202_name', value:'咪咕游戏-黑名单删除', seqno:'']
		list << [name:'2202_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2202_out_mapping', value:'1|operateStatusReturnCode,2|operateProcessResultDesc', seqno:'']
		
		list << [name:'2203_name', value:'咪咕游戏-营销消息屏蔽', seqno:'']
		list << [name:'2203_in_mapping', value:'1|userMobile,2|mobileNoSource,3|shieldRange', seqno:'']
		list << [name:'2203_out_mapping', value:'', seqno:'']
		
		list << [name:'2204_name', value:'咪咕游戏-营销消息屏蔽取消', seqno:'']
		list << [name:'2204_in_mapping', value:'1|userMobile,2|shieldRange', seqno:'']
		list << [name:'2204_out_mapping', value:'', seqno:'']
		
		list << [name:'2205_name', value:'咪咕游戏-灰名单新增', seqno:'']
		list << [name:'2205_in_mapping', value:'1|userMobile,2|grayRosterSource', seqno:'']
		list << [name:'2205_out_mapping', value:'1|operateStatusReturnCode,2|operateProcessResultDesc', seqno:'']
		
		list << [name:'2206_name', value:'咪咕游戏-灰名单删除', seqno:'']
		list << [name:'2206_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'2206_out_mapping', value:'1|operateStatusReturnCode,2|operateProcessResultDesc', seqno:'']
		
		
		
		list << [name:'3101_name', value:'咪咕音乐-短/彩信黑名单查询', seqno:'']
		list << [name:'3101_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'3101_out_mapping', value:'1|recordNo,2|userMobile,3|blackRosterType,4|blackRosterCreateTime,5|blackRosterRemarkInfo,6|blackRosterOperateResult', seqno:'']
		
		list << [name:'3102_name', value:'咪咕音乐-点播记录查询', seqno:'']
		list << [name:'3102_in_mapping', value:'1|userMobile,2|beginTime,3|endTime,4|productType', seqno:'']
		list << [name:'3102_out_mapping', value:'1|recordNo,2|businessId,3|businessName,4|songName,5|singerName,6|chargeType,7|charge,8|downloadTime,9|operateWay,10|operateChannel', seqno:'']
		
		list << [name:'3103_name', value:'咪咕音乐-会员历史操作记录查询', seqno:'']
		list << [name:'3103_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'3103_out_mapping', value:'1|recordNo,2|memberLevel,3|operateType,4|operateWay,5|operateChannel,6|operateTime', seqno:'']
		
		list << [name:'3104_name', value:'咪咕音乐-包月历史操作记录查询', seqno:'']
		list << [name:'3104_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'3104_out_mapping', value:'1|recordNo,2|businessName,3|businessType,4|operateType,5|operateWay,6|operateChannel,7|operateTime,8|operateResult', seqno:'']
		
		list << [name:'3105_name', value:'咪咕音乐-单次消费历史记录查询', seqno:'']
		list << [name:'3105_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'3105_out_mapping', value:'1|recordNo,2|businessId,3|businessName,4|songName,5|singerName,6|chargeType,7|charge,8|downloadTime,9|operateWay,10|operateChannel,11|downloadStatus', seqno:'']
		
		list << [name:'3106_name', value:'咪咕音乐-彩铃订购历史记录查询', seqno:'']
		list << [name:'3106_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'3106_out_mapping', value:'1|recordNo,2|songId,3|songName,4|singerName,5|charge,6|orderType,7|orderChannel,8|orderTime,9|returnCode,10|returnDesc', seqno:'']
		
		list << [name:'3107_name', value:'咪咕音乐-合作渠道黑名单查询', seqno:'']
		list << [name:'3107_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'3107_out_mapping', value:'1|recordNo,2|province,3|operateStaff,4|operateTime', seqno:'']
		
		list << [name:'3108_name', value:'咪咕音乐-短信上下行记录查询', seqno:'']
		list << [name:'3108_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'3108_out_mapping', value:'1|recordNo,2|userMobile,3|channelName,4|channelCode,5|sendTime,6|updownFlag,7|smsContent,8|smsPort,9|smsStatus,10|returnDesc', seqno:'']
		
		list << [name:'3201_name', value:'咪咕音乐-短/彩信屏蔽或取消屏蔽', seqno:'']
		list << [name:'3201_in_mapping', value:'1|userMobile,2|operateType,3|blackRosterType', seqno:'']
		list << [name:'3201_out_mapping', value:'', seqno:'']
		
		list << [name:'3202_name', value:'咪咕音乐-合作渠道黑名单添加', seqno:'']
		list << [name:'3202_in_mapping', value:'1|userMobile,2|province,3|operateStaff', seqno:'']
		list << [name:'3202_out_mapping', value:'', seqno:'']
		
		
		
		list << [name:'4101_name', value:'咪咕动漫-点播记录查询', seqno:'']
		list << [name:'4101_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'4101_out_mapping', value:'1|recordNo,2|worksName,3|playTime,4|worksMoneyAmount,5|cpName,6|channelId,7|channelName,8|officeDataId', seqno:'']
		
		list << [name:'4102_name', value:'咪咕动漫-包月信息查询', seqno:'']
		list << [name:'4102_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'4102_out_mapping', value:'1|recordNo,2|productId,3|productName,4|orderStatus,5|orderTime,6|expireTime,7|orderChannel', seqno:'']
		
		list << [name:'4103_name', value:'咪咕动漫-黑名单查询', seqno:'']
		list << [name:'4103_in_mapping', value:'1|userMobile,2|shieldType', seqno:'']
		list << [name:'4103_out_mapping', value:'1|userMobile,2|shieldType,3|shieldStatus,4|syncSource,5|operateStaff,6|operateTime,7|operateResult', seqno:'']
		
		list << [name:'4104_name', value:'咪咕动漫-灰名单查询', seqno:'']
		list << [name:'4104_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'4104_out_mapping', value:'1|userMobile,2|operateDate,3|operateWay,4|manageControlWay,5|syncSource,6|operateStaff,7|remark', seqno:'']
		
		list << [name:'4105_name', value:'咪咕动漫-动漫杂志接收状态查询', seqno:'']
		list << [name:'4105_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'4105_out_mapping', value:'1|operateResult', seqno:'']
		
		list << [name:'4106_name', value:'咪咕动漫-包月配额查询', seqno:'']
		list << [name:'4106_in_mapping', value:'1|userMobile,2|queryYear,3|queryMonth', seqno:'']
		list << [name:'4106_out_mapping', value:'1|userMobile,2|businessName,3|beginTime,4|endTime,5|totalQuota,6|usedQuota,7|remainQuota', seqno:'']
		
		list << [name:'4110_name', value:'咪咕动漫-用户账户查询', seqno:'']
		list << [name:'4110_in_mapping', value:'1|userId', seqno:'']
		list << [name:'4110_out_mapping', value:'1|registerTime,2|province,3|city,4|comicCoinRemain,5|businessName,6|shouldPrivilege,7|alreadyPrivilege,8|remainAmount', seqno:'']
		
		list << [name:'4111_name', value:'咪咕动漫-包月订购关系历史记录查询', seqno:'']
		list << [name:'4111_in_mapping', value:'1|userId,2|beginTime,3|endTime', seqno:'']
		list << [name:'4111_out_mapping', value:'1|productId,2|productName,3|cpName,4|operateTime,5|operateWay,6|accessWay,7|smsAccessCode,8|channelName,9|operateResult', seqno:'']
		
		list << [name:'4112_name', value:'咪咕动漫-消费记录查询', seqno:'']
		list << [name:'4112_in_mapping', value:'1|userId,2|beginTime,3|endTime,4|chargeType,5|payWay', seqno:'']
		list << [name:'4112_out_mapping', value:'1|businessId,2|businessName,3|productId,4|productName,5|consumeMoneyAmount,6|consumeWay,7|useWay,8|cpName,9|channelName,10|payWay,11|bossId', seqno:'']
		
		list << [name:'4113_name', value:'咪咕动漫-短信上下行查询', seqno:'']
		list << [name:'4113_in_mapping', value:'1|userId,2|beginTime,3|endTime,4|updownFlag,5|accessNo', seqno:'']
		list << [name:'4113_out_mapping', value:'1|recordNo,2|userMobile,3|updownFlag,4|accessNo,5|sendTime,6|smsContent', seqno:'']
		
		list << [name:'4114_name', value:'咪咕动漫-核查', seqno:'']
		list << [name:'4114_in_mapping', value:'1|userId,2|businessId,3|consumeTime,4|bossId', seqno:'']
		list << [name:'4114_out_mapping', value:'1|checkResult', seqno:'']
		
		list << [name:'4201_name', value:'咪咕动漫-黑名单加载', seqno:'']
		list << [name:'4201_in_mapping', value:'1|userMobile,2|shieldType', seqno:'']
		list << [name:'4201_out_mapping', value:'1|operateResult', seqno:'']
		
		list << [name:'4202_name', value:'咪咕动漫-黑名单删除', seqno:'']
		list << [name:'4202_in_mapping', value:'1|userMobile,2|shieldType', seqno:'']
		list << [name:'4202_out_mapping', value:'1|operateResult', seqno:'']
		
		list << [name:'4203_name', value:'咪咕动漫-业务补发', seqno:'']
		list << [name:'4203_in_mapping', value:'1|userMobile,2|businessId,3|remedyDate', seqno:'']
		list << [name:'4203_out_mapping', value:'1|queryResult', seqno:'']
		
		list << [name:'4204_name', value:'咪咕动漫-灰名单加载/删除', seqno:'']
		list << [name:'4204_in_mapping', value:'1|userMobile,2|operateWay', seqno:'']
		list << [name:'4204_out_mapping', value:'1|operateResult', seqno:'']
		
		list << [name:'4205_name', value:'咪咕动漫-动漫杂志接收状态恢复', seqno:'']
		list << [name:'4205_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'4205_out_mapping', value:'1|operateResult', seqno:'']
		
		list << [name:'4206_name', value:'咪咕动漫-同步退订功能', seqno:'']
		list << [name:'4206_in_mapping', value:'1|userId,2|productId,3|endTime', seqno:'']
		list << [name:'4206_out_mapping', value:'1|operateResult', seqno:'']
		
		
		
		list << [name:'5101_name', value:'咪咕视频-营销短彩信查询', seqno:'']
		list << [name:'5101_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'5101_out_mapping', value:'1|recordNo,2|userMobile,3|shieldBusiness,4|lastSetTime', seqno:'']
		
		list << [name:'5102_name', value:'咪咕视频-包月信息查询', seqno:'']
		list << [name:'5102_in_mapping', value:'1|userMobile,2|beginTime,3|endTime,4|queryType', seqno:'']
		list << [name:'5102_out_mapping', value:'1|recordNo,2|productCode,3|productName,4|enterpriseCode,5|enterpriseName,6|chargeType,7|operateApproach,8|operateRecord,9|operateTime,10|operateStaff', seqno:'']
		
		list << [name:'5103_name', value:'咪咕视频-点播信息查询', seqno:'']
		list << [name:'5103_in_mapping', value:'1|userMobile,2|beginTime,3|endTime,4|chargeType', seqno:'']
		list << [name:'5103_out_mapping', value:'1|recordNo,2|productCode,3|productName,4|programId,5|programName,6|watchTime,7|chargeType,8|chargeAmount', seqno:'']
		
		list << [name:'5104_name', value:'咪咕视频-适配机型查询', seqno:'']
		list << [name:'5104_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'5104_out_mapping', value:'1|recordNo,2|phoneModel,3|phoneBrand,4|screenSize,5|supportLte,6|supportLiveWatch,7|supportDownloadWatch,8|richMediaClientAdapt,9|simplyUIAdapt,10|androidClientAdapt', seqno:'']
		
		list << [name:'5105_name', value:'咪咕视频-异常稽核用户查询', seqno:'']
		list << [name:'5105_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'5105_out_mapping', value:'1|recordNo,2|queryResult', seqno:'']
		
		list << [name:'5106_name', value:'咪咕视频-灰名单查询', seqno:'']
		list << [name:'5106_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'5106_out_mapping', value:'1|recordNo,2|queryResult,3|joinImageVerifyCodeTime,4imageVerifyCodeValidTerm', seqno:'']
		
		list << [name:'5107_name', value:'咪咕视频-使用记录查询', seqno:'']
		list << [name:'5107_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'5107_out_mapping', value:'1|recordNo,2|beginTime,3|productName,4|programId,5|programName,6|useDuration,7|chargeType,8|flowAmount,9|netType,10|playWay,11|accessType,12|productId', seqno:'']
		
		list << [name:'5108_name', value:'咪咕视频-黑名单查询', seqno:'']
		list << [name:'5108_in_mapping', value:'1|userMobile', seqno:'']
		list << [name:'5108_out_mapping', value:'1|recordNo,2|queryResult,3|joinBlackRosterTime,4|blackRosterValidTerm', seqno:'']
		
		list << [name:'5109_name', value:'咪咕视频-用户帐户查询', seqno:'']
		list << [name:'5109_in_mapping', value:'1|userId', seqno:'']
		list << [name:'5109_out_mapping', value:'1|registerTime,2|registerAccount,3|updateTime,4|userStatus,5|businessStatus,6|userBelongPlace,7|filmCoinRemainAmount,8|rechargeCardRemainAmountalipayRemainAmount,9|virtualGoldenCoinRemainAmount', seqno:'']
		
		list << [name:'5110_name', value:'咪咕视频-消费记录查询', seqno:'']
		list << [name:'5110_in_mapping', value:'1|userMobile,2|beginTime,3|endTime,4|chargeType', seqno:'']
		list << [name:'5110_out_mapping', value:'1|recordNo,2|productCode,3|productName,4|programId,5|programName,6|watchTime,7|chargeType,8|chargeAmount', seqno:'']
		
		list << [name:'5111_name', value:'咪咕视频-充值记录查询', seqno:'']
		list << [name:'5111_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'']
		list << [name:'5111_out_mapping', value:'1|recordNo,2|rechargeId,3|rechargeTime,4|rechargeAmount,5|operateType,6|rechargeType', seqno:'']
		
		list << [name:'5201_name', value:'咪咕视频-营销短彩信激活或屏蔽', seqno:'']
		list << [name:'5201_in_mapping', value:'1|userMobile,2|shieldBusiness,3|operateType,4|operateStaffName,5|operateStaffId,6|provinceId', seqno:'']
		list << [name:'5201_out_mapping', value:'', seqno:'']
		
		list << [name:'5202_name', value:'咪咕视频-灰名单加载/删除', seqno:'']
		list << [name:'5202_in_mapping', value:'1|userMobile,2|imageVerifyCodeValidTerm,3|operateStaffName,4|operateStaffId,5|provinceId,6|operateType', seqno:'']
		list << [name:'5202_out_mapping', value:'', seqno:'']
		
		list << [name:'5203_name', value:'咪咕视频-黑名单加载/删除', seqno:'']
		list << [name:'5203_in_mapping', value:'1|userMobile,2|blackRosterValidTerm,3|operateStaffName,4|operateStaffId,5|provinceId,6|operateType', seqno:'']
		list << [name:'5203_out_mapping', value:'', seqno:'']
		
		list << [name:'', value:'', seqno:'30']
		list << [name:'', value:'', seqno:'30']
		list << [name:'', value:'', seqno:'30']
		list << [name:'', value:'', seqno:'30']
		list
	}
	
	@Override
	Map getEncryptRel() {
		[stgid:'3']
	}
	
	@Override
	Map getSecretKey() {
		[stgid:'3', key1:'a67aae2843b7e6dc83298b9532082522,504089', key2:'a67aae2843b7e6dc83298b9532082522']
	}
	
	@Override
	Map getCallbackMapping() {
		[addr:'/dualmicro/releaseNotice', clsnm:'dualmicroCallBackService']
	}
	
	@Override
	Map getCallback() {
		[code:'1', method:'POST', addr:'/business/flows/mobiles/gs/resultNotice']
	}
	
	@Test
	void testExecute() {
		def file = new File(sqlFile.dir + sqlFile.name + '.sql')
		file.write('')
		file << inInterfaceSql
		file << outInterfaceSql
		file << interfaceMappingSql
		inInterfaceParamsSql.each{
			file << it
		}
		outInterfaceParamsSql.each{
			file << it
		}
		interfaceParamsMappingSql.each{
			file << it
		}
		outInterfaceParamsStaticSql.each{
			file << it
		}
		file << channelAuthSql
	}
}
