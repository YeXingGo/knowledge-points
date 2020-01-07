package com.zh.java.内部类;

/**
 * @描述： TODO  测试方法内部类
 * @作者: Light
 * @时间: 2019/10/6  17:31
 * @版本：
 */
public class Parcel6 {
     {
        System.out.println("static Parcel6");
    }
    public Parcel6 () {
        System.out.println("Parcel6 >>>>>>>>>>>>>>>");
    }
    private void internalTracking(boolean b) {
        if (b) {
            class  TrackingSlip {
                 {
                    System.out.println("TrackingSlip");
                }
                private String id;

                public TrackingSlip(String id) {
                    this.id = id;
                }
                String getId () {
                    return id ;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("slip");
            System.out.println(trackingSlip.getId());
        }
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.internalTracking(true);
    }
}
