# Interface Document

backend: port: 8080

2020/07/03

操作 =》 /man/updateManufacturer

{

MAN_ID

USER_ID:STRING  1

GMC_REPORT_TYPE

GMC_REPORT_URL

DESCRIPTION

CREATED_BY: STRING  1	

}

保存 -》 /man/addOrUpdateManufacturer

{

MAN_ID

USER_ID:STRING  1

GMC_REPORT_TYPE

GMC_REPORT_URL

DESCRIPTION

CREATED_BY: STRING  1	

}



开始 =》 /man/getManufacturer

操作 => 跳转页面

品牌信息

获取

/brand/getBrandByFilter

{

​	MAN_IDS

}

新增 /brand/addBrand 

{

​	MAN_ID

​	NAME_EN
​	NAME_CN

​	CREATED_BY: 1

}



修改  /brand/updateBrand

{

​	BRD_ID

​	MAN_ID

​	NAME_EN
​	NAME_CN

​	CREATED_BY: 1

​	IMAGE_URL：

}



删除 /delete/deleteBrandS

{

​	BRD_ID

​	MAN_ID

​	NAME_EN
​	NAME_CN

​	CREATED_BY: 1

​	IMAGE_URL：

}