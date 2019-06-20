package com.wei.first.bean.publicBean;

/**
 * FileName：ResCode
 *
 * @author 魏俊杰
 * @date 16:07 2019/5/26
 */
public enum ResCode {
    SUCCESS200("200","成功"),
    SUCCESS("0000", "成功"),
    SIGN_NULL("0001","延签不能为空！"),
    SIGN_ERROR("0002","延签不一致！"),
    CUSTOMER_NULL("0003","客户号不存在！"),
    OPERATOR_NULL("0004","操作用户不存在！"),
    BALANCE_AMOUNT_ERROR("0005", "结算存在金额不一致"),
    SYS_USER_NULL("0006","账号或密码错误"),
    MERCHANT_CODE_ERROR("0007","导入的商户表格错误"),
    SHANYIN_SELLERID_ERROR("0008","导入的闪银门店id格式错误"),
    CONTRACT_NO_MISS("0009","合同号不存在"),
    NOT_LOAN_FAILED("0010","该资产非放款失败状态"),
    FINANCE_PROVIDER_MERCHANT_NULL("0012","资金方、资产方、商户编号不能同时为空"),
    FAIL_ERROR("1000", "请求失败."),
    RESULT_NULL("9996", "结果集为空"),
    ARGUMENTS_ERROR("9997", "参数校验错误."),
    SYSTEM_ERROR("9998", "系统异常，请联系相关技术人员."),

    REPEAT_SUBMIT_ERROR("9800", "1秒之内请勿重复提交！"),
    ERROR("9999", "请求系统异常,请稍候再试"),
    CANCEL_ERROR("0033","该笔资产不能取消！"),
    FAIL("0013","万瑞兜底失败"),
    TYPE_ERROR("0014","类型错误"),
    ASSET_LOANED("0015","操作失败，资产已经是已放款状态"),
    PROCESSING("0016","请求处理中，请勿重复提交"),
    ASSET_STATUS_WRONG("0017","资产状态错误"),
    NO_USER("2001","当前账户未注册");




    private String code;
    private String msg;

    ResCode(String code, String msg){
        this.code=code;
        this.msg=msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
