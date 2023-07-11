package com.leo.fly.common.enums;

import com.leo.fly.common.service.BaseErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
　 * <p>Title: ErrorCodeEnum.java</p> 
　 * <p>Description: </p> 
　 * <p>Company: </p> 
　 * @author Leo.Lyn 
　 * @date 2019年11月20日 
　 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum implements BaseErrorEnum {
	E_404("000404","404 not found","404 not found", "1"),	
	E_REQUEST_METHOD("000405","Request method not supported","Request method not supported", "1"),	
	E_CONTENT_TYPE("000406","Content type not supported","Content type not supported", "1"),	
	E_ENCODING("000407","Encoding not supported","Content type not supported", "1"),	
	E_COOKIE_INVALID("000409","cookie invalid","cookie invalid", "1"),
	E_SERVER_CONNECT_REFUSE("000500","E_SERVER_CONNECT_REFUSE","E_SERVER_CONNECT_REFUSE", "1"),

	E_SIGN("000900","sign fail !","sign fail exception", "1"),	
	E_KEY_IS_NULl("000999","Key is null","Key is null", "1"),
	E_KEY_LENGTH_INVALID("000998","Key's length invalid","Key's length invalid", "1"),
	E_METHOD_ARGUMENT_NOT_VALID("000997","Method Argument Not Valid Exception","Method Argument Not Valid Exception", "1"),	
	E_VALIDATION("000996","Validation Exception","Validation Exception", "1"),	
	E_REQUEST_INVALID("000995","request invalid","request invalid", "1"),
	E_AUTHORIZED("000994","authorized fail !","authorized fail exception", "1"),
	E_AUTHORIZED_1688("001994","1688授权过期,请重新授权...!","1688授权过期,请重新授权...", "1"),
	E_AUTHORIZED_1688_ORDER("002994","1688授权过期,请重新授权...!","1688授权过期,请重新授权...", "1"),
	E_UPLOAD_1688("001995","上传失败","上传失败", "1"),
	E_1688_PRODUCT_ADD("001996","上传失败","上传失败", "1"),
	E_1688_PRODUCT_DELETE("001997","删除失败","删除失败", "1"),
	E_NOT_RIGHT("000993","have not right!","have not right!", "1"),
	E_PARSE_EXCEPTION("000992","E_PARSE_EXCEPTION!","E_PARSE_EXCEPTION!", "1"),
	E_USER_ONLY_ONCE("000991","A user can only participate once","A user can only participate once", "1"),

	E_OTHERS("000001","","", "1"), 
	E_LOGIN("000002","expires request!","expires request", "1"),
	E_NO_RECORD("000003","not record","not record", "1"),
	E_NO_RECORDS("000003","not records","not records!", "1"),

	E_GET_ONE_TO_MORE("001003","E_GET_ONE_TO_MORE","E_GET_ONE_TO_MORE!", "1"),
	E_FLOW_IS_DONE("000004","resubmit invalid","resubmit invalid!", "1"),
	E_TRADE_NOT_DEFINED("00005","trade not defined exception!","trade not defined exception!", "1"),
	E_MAP_TO_BEAN("000005","syntax error","syntax error!", "1"),
	E_BEAN_TO_MAP("000006","bean to map error","bean to map error!", "1"),
	E_PARSE_BEAN("000007","parse bean error","parse bean error!", "1"),
	E_REMOTE_API("000008","Remote Api error","Remote Api error!", "1"),
	E_AES_ENCRYPT("000009","encrypt error","encrypt error!", "1"),
	E_AES_DECRYPT("000010","decrypt error","decrypt error!", "1"),
	E_GENERATE_TRANSACTION_CODE("000011","generate transaction code error","generate transaction code error!", "1"),
	E_PLATFORM_INVALID("000012","platform invalid","platform invalid!", "1"),
	E_RECORD_EXISTS("000013","record is exists","record is exists!", "1"),
	E_MESSAGE_REPEAT_SEND("000014","E_MESSAGE_REPEAT_SEND","E_MESSAGE_REPEAT_SEND!", "1"),


	E_USER_EXISTS("083003", "该账号已存在!请更换账号!", "the user is exists", "1"),
	E_USER_NOT_FOUND("000601","USER_NOT_FOUND","USER_NOT_FOUND", "1"),
	E_USER_STATUS("000602","user status invalid","user status invalid", "1"),
	E_ROLE_NOT_FOUND("000603","USER_NOT_FOUND","USER_NOT_FOUND", "1"),

	E_ORDER_PARAM_INVALID("000801","order param invalid!","order param invalid!", "1"),
	E_ORDER_PRODUCT_INVALID("000802","product not found invalid!","product not found invalid!", "1"),
	E_18_YEAR_OLD("000803","under the age of 18","under the age of 18","1"),
	E_18_YEAR_OLD_ZH("000804","未满18周岁","under the age of 18","1"),

	E_FILE_IS_NULL("000700","FILE_IS_NULL","FILE_IS_NULL","1"),
	E_PAYMENT_INVALID("000701","参数校验失败","E_PAYMENT_INVALID","1"),
	E_SCALPING_URL_INVALID("000702","无效链接","E_URL_INVALID","1"),
	E_SCALPING_TASK_STATUS_INVALID("000703","状态错误","E_SCALPING_TASK_STATUS_INVALID","1"),
	E_SCALPING_TASK_PARAMS_INVALID("000704","参数错误","E_SCALPING_TASK_STATUS_INVALID","1"),
	E_SCALPING_ORDER_URL_INVALID("000705","无效的链接","E_SCALPING_ORDER_URL_INVALID","1"),
	E_FILE_NOT_EXISTS("000706","E_FILE_NOT_EXISTS","E_FILE_NOT_EXISTS","1"),
	E_FILE_IS_NOT_FILE("000708","E_FILE_IS_NOT_FILE","E_FILE_IS_NOT_FILE","1"),
	E_FILE_EXISTS("000707","E_FILE_EXISTS","E_FILE_EXISTS","1"),
	SUCCESS("000000","SUCCESS","SUCCESS", "1"),
	E_PRODUCT_CODE("000808", "CODE LENGTH NOT ENOUGH","SUCCESS", "1"),
	E_PRODUCT_JSON("000809", "JSON IS NULL","SUCCESS", "1"),
	E_PRODUCT_PRE_DELETE("000810", "JPRODUCT_PRE_DELETE","PRODUCT_PRE_DELETE", "1"),
	E_YP_LIMIT("000811", "E_YP_LIMIT","E_YP_LIMIT", "1")
	;

    //错误码
	private final String code;
	//后台错误信息描述
	private final String remark;
	//返回客户端错误信息描述
	private final String i18remark;
	//错误类型（备用字段）
	private final String type;


	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public String getI18Remark() {
		return i18remark;
	}

	@Override
	public String getType() {
		return type;
	}
}
