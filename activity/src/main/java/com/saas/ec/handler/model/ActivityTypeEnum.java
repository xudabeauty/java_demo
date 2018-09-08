package com.saas.ec.handler.model;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum ActivityTypeEnum {

    PROMOTION(1, "promotion", "满减满折", "满减满折", "减"),
    FREEFREIGHT(2, "free_freight", "满包邮", "满包邮", "邮"),
    DISCOUNT(3, "discount", "限时折扣", "限时抢", "限"),
    BARGAIN(4, "bargain", "砍价", "砍价", "砍"),
    GROUPON(5, "groupon", "拼团", "拼团", "拼"),
    COUPON(6, "coupon", "优惠券", "优惠券", "券"),
    COUPONCODE(9, "coupon_code", "优惠码", "优惠码", "码"),
    PRIVILEGE_PRICE(10, "privilege_price", "特权价", "特权价", "特"),
    PAYMENT_PROMOTION(11, "payment_promotion", "支付推广", "支付推广", "推"),
    NYNJ(12, "nynj", "N元N件", "任选", "N"),
    COMBINATION_BUY(13, "combination", "优惠套装", "优惠套装", ""),
    REDEMPTION(14, "redemption", "加价购", "加价购", ""),
    FULL_SUBTRACT(15, "full_subtract", "满减满折", "满减", "减"),
    FULL_DISCOUNT(16, "full_discount", "满减满折", "满折", "折"),
    MEMBERSHIP(17, "membership", "新零售会员", "会员", "会员"),
    RESERVE(18, "reserve", "预约到店", "预约到店", "预约到店"),
    ;

    private int type;
    /** 类型标识名称（可读） */
    private String typeName;
    private String name;
    //c端显示的标签名
    private String frontTagText;
    //b端显示的标签名
    private String backendTagText;


    // 活动类型有效类型的名称集
    private static Map<String, ActivityTypeEnum> EFFICTIVE_ACTIVITY_TYPE_NAME = null;
    // 活动类型有效类型的数字集
    private static Map<Integer, ActivityTypeEnum> EFFICTIVE_ACTIVITY_TYPE_NUMBER = null;
    static {
        EFFICTIVE_ACTIVITY_TYPE_NAME = new HashMap<>(ActivityTypeEnum.values().length);
        EFFICTIVE_ACTIVITY_TYPE_NUMBER = new HashMap<>(ActivityTypeEnum.values().length);
        for (ActivityTypeEnum activityType : ActivityTypeEnum.values()) {
            EFFICTIVE_ACTIVITY_TYPE_NAME.put(activityType.getTypeName(), activityType);
            EFFICTIVE_ACTIVITY_TYPE_NUMBER.put(Integer.valueOf(activityType.getType()), activityType);
        }
    }

    public static ActivityTypeEnum convert(String typeName) {
        if (StringUtils.isBlank(typeName)) {
            throw new IllegalArgumentException("参数为空，不能识别活动类型。");
        }

        // 可以识别的有效输入
        if(EFFICTIVE_ACTIVITY_TYPE_NAME.keySet().contains(typeName)) {
            return EFFICTIVE_ACTIVITY_TYPE_NAME.get(typeName);
        }

        throw new IllegalArgumentException("非法输入，不可识别的活动类型。");
    }

    public static ActivityTypeEnum convert(Integer type) {
        if (type == null) {
            throw new IllegalArgumentException("参数为空，不能识别活动类型。");
        }

        // 可以识别的有效输入
        if (EFFICTIVE_ACTIVITY_TYPE_NUMBER.keySet().contains(type)) {
            return EFFICTIVE_ACTIVITY_TYPE_NUMBER.get(type);
        }

        throw new IllegalArgumentException("非法输入，不可识别的活动类型。");
    }

    public static ActivityTypeEnum getActivityType(int value) {
        return convert(Integer.valueOf(value));
    }

    private ActivityTypeEnum(int type, String typeName, String name, String frontTagText, String backendTagText) {
        this.type = type;
        this.typeName = typeName;
        this.name = name;
        this.frontTagText = frontTagText;
        this.backendTagText = backendTagText;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getName() {
        return name;
    }

    public String getFrontTagText() {
        return frontTagText;
    }

    public String getBackendTagText() {
        return backendTagText;
    }
}
