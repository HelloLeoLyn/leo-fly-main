package com.leo.fly.common.enums;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel
@Getter
@AllArgsConstructor
public enum Platform {

	/**
	 * instagram 刷量平台
	 */
	IG("IG","instagram","Instagram转贴","Instagram",0,"IG",30,"ccd91278035e6ec4","ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636"),

	IG2("IG2","instagram","Instagram分析者","Instagram 分析者",0,"IG",30,"ccd91278035e6ec4","c3627b4de455e445e0ff366dc2245d3d","ed2208c692e645d4a002add3048ad576"),

	ZW("ZW","ziwei","紫微斗数","ziwei",0,"ZW",30,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	NA("NA","name version A","起名A版本","name version A",0,"NA",30,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	NB("NB","name version base","起名基本版本","name version base",0,"NB",30,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	SYS("SYS","SYSTEM ADMIN","SYSTEM ADMIN","SYSTEM ADMIN",1,"SYS",60,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	TEST("TEST","SYSTEM ADMIN","SYSTEM ADMIN","SYSTEM ADMIN",1,"SYS",60,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	YUN("YUN","numerology","numerology","numerology",1,"NA",30,"ccd91278035e6ec4","9fd3b5e6ea217f0c63f50eb86ec2867e",""),

	SCP("SCP","SCALPING","SCALPING","SCALPING",1,"SCP",60,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	JXT("JXT","JXT","JXT","JXT",1,"JXT",60,"ccd91278035e6ec4","6407ed45c7d04f959004d685cede9636",""),

	;

	private final String id;
	private final String name;
	private final String remark;
	private final String i18remark;
	private final int token_flag;
	private final String query;
	private final long session;
	private final String key16;
	private final String key32;
	private final String appleSecret;
}
