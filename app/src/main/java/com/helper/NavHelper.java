package com.helper;

import com.google.gson.Gson;
import com.iwant.agv.agv2rostest04.model.NavCtrl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by super_yu on 26/10/2017.
 */

public class NavHelper {

    /**
     * 获取导航状态
     *
     * @return cmd
     */
    public static String getNavStatus() {
        Nav_Ctrl_StatusUtil navCtrlStatusUtil = new Nav_Ctrl_StatusUtil();
        navCtrlStatusUtil.setOp("subscribe");
        navCtrlStatusUtil.setTopic("/nav_ctrl_status");
        String json = new Gson().toJson(navCtrlStatusUtil);
        return json;
    }

    public static String getTime() {
        String msg = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss.SSS");
        msg += "[" + sdf.format(date) + "]";
        return msg;
    }

    public static String nav(int control,String pointName){
        NavCtrl na = new NavCtrl();
        NavCtrl.MsgBean nam = new NavCtrl.MsgBean();
        nam.setControl(control);
        nam.setGoal_name(pointName);
        na.setMsg(nam);
        return new Gson().toJson(na);
    }
}