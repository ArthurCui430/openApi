package com.sage.auto.api;

import net.sf.json.JSONObject;

public class AutoApi
{
  public static String REQUESTACCOUNT = "atzuche";
  public static String SECRET_KEY = "sagecrm";

  public static String wechatSubscrible(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/fansmember!wechatSubscrible.do", jsonObject.toString());
  }

  public static String webInteraction(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/fansmember!webInteraction.do", jsonObject.toString());
  }

  public static String callCenterMember(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/callcenter!callCenterMember.do", jsonObject.toString());
  }

  public static String callCenterInfo(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/callcenter!callCenterInfo.do", jsonObject.toString());
  }

  public static String updateCallcenterInfo(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/callcenter!updateCallcenterInfo.do", jsonObject.toString());
  }

  public static String voucherRuleCheck(String params) {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post("http://121.43.232.35:8091/api/auto/voucher!voucherRuleCheck.do", jsonObject.toString());
  }

  public static String getToken()
  {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("appId", "39ad02eee7187c71cae091b7d00ec4f04c321ca1");
    jsonObject.put("appSecret", "246a4843a0e84e04e9d10668ca9aa3528c31a4ab");
    jsonObject.put("sign", "365b4825c579b131ea7751e91563f16c");

    String result = ApiUtils.post("http://omstest.joojtech.com/Api/V1/Auth/index", jsonObject.toString());

    return result;
  }

  public static String post(String url, String params)
  {
    JSONObject jsonObject = JSONObject.fromObject(params);
    jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    return ApiUtils.post(url, jsonObject.toString());
  }

  public static void main(String[] args) {
//    JSONObject jsonObject = new JSONObject();
//    jsonObject.put("requestAccount", "atzuche");
//    jsonObject.put("mobile", "18317117222");
//    jsonObject.put("phone", "");
//    jsonObject.put("name", "test");
//    jsonObject.put("sex", "1");
//
//    String post = post("http://localhost:8080/api/jooj/ShippingAddressAction!getshippingaddresslist.do", jsonObject.toString());
//    System.out.println(post);
//    
    
    //JSONObject jsonObject = JSONObject.fromObject("{}");
    //jsonObject.put("sign", Md5Utils.getMD5Str(REQUESTACCOUNT + SECRET_KEY));
    String json ="<?xml version=\"1.0\" encoding=\"utf-8\"?>"
    		+ "<orderHeaderDto>"
      		+ "<externalId>ESB4JE914RHFC9SZ</externalId>"
      		+ "<cardNo>10000000000035</cardNo>"
      		+ "<memberCode>M0000000212</memberCode>"
      		+ "<channelId>104</channelId>"
      		+ "<productStoreId>{F0EE8FFC-2160-4099-A18A-6239104E548A}</productStoreId>"
      		+ "<productStoreName>分店</productStoreName>"
      		+ "<orderDate>20140218</orderDate>"
      		+ "<createTime>20140218144419</createTime>"
      		+ "<orderAmount>33</orderAmount>"
      		+ "<payAmount>33</payAmount>"
      		+ "<tableFor>1</tableFor>"
      		+ "<optType>i</optType>"
      		+ "<ActiveCode>ESB6KE994EBFC9BE</ActiveCode>"
      		+ "<statusId>4</statusId>"
      		+ "<dataVersion>1</dataVersion>"
      		+ "<mobile/>"
      		+ "<orderItemDto>"
      		+ "<externalItemId>1</externalItemId>"
      		+ "<name>地动心摇(新)</name>"
      		+ "<productCode>206</productCode>"
      		+ "<quantity>1.00</quantity>"
      		+ "<unitPrice>33.00</unitPrice>"
      		+ "<amount>33.00</amount>"
      		+ "<groupId>15</groupId>"
      		+ "<isCoupon>N</isCoupon>"
      		+ "</orderItemDto>"
      		+ "<orderItemDto>"
      		+ "<externalItemId>2</externalItemId>"
      		+ "<name>标杯 荔枝芝士蛋糕</name>"
      		+ "<productId>20045</productId>"
      		+ "<quantity>1.00</quantity>"
      		+ "<unitPrice>0.00</unitPrice>"
      		+ "<amount>0.00</amount>"
      		+ "<groupId>11</groupId>"
      		+ "<isCoupon>Y</isCoupon>"
      		+ "</orderItemDto>"
      		+ "<orderCouponDto>"
      		+ "<externalItemId>2</externalItemId>"
      		+ "<couponInstanceCode>000166112</couponInstanceCode>"
      		+ "<couponAmount>0.00</couponAmount>"
      		+ "</orderCouponDto>"
      		+ "<orderPayDto>"
      		+ "<externalItemId>1</externalItemId>"
      		+ "<name>现金</name>"
      		+ "<PayId>1</PayId>"
      		+ "<Amount>33.00</Amount>"
      		+ "</orderPayDto>"
      		+ "</orderHeaderDto>";
    
    String result = ApiUtils.sendPost("http://localhost:8080/scrm-web-main/rs/external/api/order/handleSyncOrder", json);
    System.out.println(result); 
  }
}