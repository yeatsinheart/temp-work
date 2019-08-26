package com.max.core.utils;

import com.max.core.constant.ProjectConstant;

public class ClientUtils {

    // 显示端：0现金网PC，1现金网APP，2体育APP，3代理PC，4代理APP
    public static int getShowClient(Integer os_type, Integer app) {
        int showClient = 0;
        if (app == ProjectConstant.APPType.CASH) {
            if (os_type == ProjectConstant.OSType.PC) {
                showClient = 0;
            } else {
                showClient = 1;
            }
        } else if (app == ProjectConstant.APPType.SPORT) {
            showClient = 2;
        } else if (app == ProjectConstant.APPType.PROXY) {
            if (os_type == ProjectConstant.OSType.PC) {
                showClient = 3;
            } else {
                showClient = 4;
            }
        }
        return showClient;
    }

    /**
     * 产品端维护类型(1:会员-PC端,2:会员-IOS端,3:会员-ANDROID端,4:代理-PC端,5:代理-IOS端,6:代理-ANDROID端,7:体育-IOS端,8:体育-ANDROID端,9:会员-H5端)
     *
     * @param os_type -1ALL, 0PC，1H5，2安卓，3IOS，4PAD
     * @param app     -1ALL, 0现金网，1体育，2代理
     * @return int
     * @author Chaims
     * @date 2019/3/29 11:06
     */
    public static int getProductType(Integer os_type, Integer app) {
        if (os_type == null) {
            os_type = 0;
        }
        if (app == null) {
            app = 0;
        }
        int productType = 0;
        //娱乐/会员/现金网
        if (app == ProjectConstant.APPType.CASH) {
            if (os_type == ProjectConstant.OSType.PC) {
                productType = 1;
            } else if (os_type == ProjectConstant.OSType.IOS) {
                productType = 2;
            } else if (os_type == ProjectConstant.OSType.ANDROID) {
                productType = 3;
            } else if (os_type == ProjectConstant.OSType.H5) {
                productType = 9;
            }
        } else if (app == ProjectConstant.APPType.PROXY) {
            if (os_type == ProjectConstant.OSType.PC) {
                productType = 4;
            } else if (os_type == ProjectConstant.OSType.IOS) {
                productType = 5;
            } else if (os_type == ProjectConstant.OSType.ANDROID) {
                productType = 6;
            }
        } else if (app == ProjectConstant.APPType.SPORT) {
            if (os_type == ProjectConstant.OSType.IOS) {
                productType = 7;
            } else if (os_type == ProjectConstant.OSType.ANDROID) {
                productType = 8;
            }
        }
        return productType;
    }
}
