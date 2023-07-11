package com.leo.fly.ailibaba.order;


public class AlibabaTradeGetSellerOrderListResult {

    private AlibabaOpenplatformTradeModelTradeInfo[] result;

    /**
     * @return 查询返回结果
     */
    public AlibabaOpenplatformTradeModelTradeInfo[] getResult() {
        return result;
    }

    /**
     * 设置查询返回结果     *
          
     * 此参数必填
     */
    public void setResult(AlibabaOpenplatformTradeModelTradeInfo[] result) {
        this.result = result;
    }

    private String errorCode;

    /**
     * @return 错误码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码     *
          
     * 此参数必填
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    private String errorMessage;

    /**
     * @return 错误信息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 设置错误信息     *
          
     * 此参数必填
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private Long totalRecord;

    /**
     * @return 总记录数
     */
    public Long getTotalRecord() {
        return totalRecord;
    }

    /**
     * 设置总记录数     *
          
     * 此参数必填
     */
    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    private Boolean success;

    /**
     * @return 是否调用成功
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置是否调用成功     *
          
     * 此参数必填
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
