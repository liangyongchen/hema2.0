package com.hema.assist.entity;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/23:下午1:57
 * Email: 656266591@qq.com
 * Desc:
 */
public class HomeIndexData {

    /**
     * 广告列表
     */
    public List<Advertising> advertisingList;
    /**
     * 最新通知ID
     */
    public int latestNoticeId;
    /**
     * 其他导航入口
     */
    public OtherNavigation otherNavigation;
    /**
     * 活动信息
     */
    public ActivityInfo activityInfo;





    /**
     * 活动信息
     */
    public class ActivityInfo {

        /**
         * 0不可用 1可用
         */
        public boolean available;
        /**
         * 活动标签
         */
        public String tag;
        /**
         * 活动弹窗图片地址
         */
        public String popImgUrl;
        /**
         * 右角标图片地址
         */
        public String rightImgUrl;
        /**
         * 活动链接地址
         */
        public String activityUrl;
        /**
         * 活动持续天数
         */
        public int days;

    }

    /**
     * 其他导航栏入口参数
     */
    public class OtherNavigation {
        /**
         * 关于我们标题
         */
        public String aboutUsTitle;

        /**
         * 关于我们链接地址
         */
        public String aboutUsUrl;
        /**
         * 邀请有礼标题
         */
        public String invitesTitle;
        /**
         * 邀请有礼链接地址
         */
        public String invitesUrl;
        /**
         * 注册有礼标题
         */
        public String registerTitle;
        /**
         * 注册有礼链接地址
         */
        public String registerUrl;
        /**
         * 安全保障标题
         */
        public String safetyTitle;
        /**
         * 安全保障链接地址
         */
        public String safetyUrl;
        /**
         * 运营数据标题
         */
        public String operateTitle;
        /**
         * 运营数据链接地址
         */
        public String operateUrl;

    }

    /**
     * 广告列表参数
     */
    public class Advertising {
        /**
         * 广告图片地址
         */
        public String imgUrl;

        /**
         * 广告链接地址
         */
        public String openUrl;
    }
}
