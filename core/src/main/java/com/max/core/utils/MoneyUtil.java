package com.max.core.utils;

/**
 * Created by ken on 2018/5/14.
 */

import java.util.Arrays;

public class MoneyUtil {

    public static long maxPK10GYHZBonus(Long baseBonus, Long playBonus, Integer userRebate) {
        return ((900000 * userRebate) / 1000)
                / Math.round(baseBonus.doubleValue() / playBonus.doubleValue()) + playBonus;
    }

    public static long maxPK10GYJHZBonus(Long baseBonus, Long playBonus, Integer userRebate) {
        return ((2400000 * userRebate) / 1000)
                / Math.round(baseBonus.doubleValue() / playBonus.doubleValue()) + playBonus;
    }

    public static long maxBonus(int ticketId, long baseBonus, long playBonus, int userRebate) {
        if (Arrays.binarySearch(GlobalConstants.TicketType.IDS_115, ticketId) > -1) {
            return (baseBonus + userRebate * 19800) * playBonus / baseBonus;
        } else if (Arrays.binarySearch(GlobalConstants.TicketType.IDS_KL, ticketId) > -1) {
            return (baseBonus * userRebate) / 1000 + playBonus;
        } else {
            return (baseBonus + userRebate * 20000) * playBonus / baseBonus;
        }
    }

    public static Long maxBonusBySeries(Integer ticketSeriesId, long baseBonus, long playBonus,
                                        int userRebate) {
        if (ticketSeriesId == GlobalConstants.TicketSeriesType.TYPE_115) {
            return (baseBonus + userRebate * 19800) * playBonus / baseBonus;
        } else if (ticketSeriesId == GlobalConstants.TicketSeriesType.TYPE_KL) {
            return (baseBonus * userRebate) / 1000 + playBonus;
        } else {
            return (baseBonus + userRebate * 20000) * playBonus / baseBonus;
        }
    }

    public static Long seriesMoney(Integer ticketSeriesId, long baseBonus, int userRebate) {
        if (ticketSeriesId == GlobalConstants.TicketSeriesType.TYPE_115) {
            return (baseBonus + userRebate * 19800) * baseBonus / baseBonus;
        } else if (ticketSeriesId == GlobalConstants.TicketSeriesType.TYPE_KL) {
            return (14400000l * userRebate) / 1000 + 12240000;
        } else {
            return (baseBonus + userRebate * 20000) * baseBonus / baseBonus;
        }
    }

    public static long yuanToMinMoney(String yuan) {
        if (yuan == null) {
            return 0;
        }
        try {
            int pIdx = yuan.indexOf(".");
            int len = yuan.length();
            String fixed = yuan.replaceAll("\\.", "");
            return Long.valueOf(fixed);

//            if (pIdx < 0 || pIdx == len - 1) {
//                return Long.valueOf(fixed + "0000");
//            } else if (pIdx == len - 2) {
//                return Long.valueOf(fixed + "000");
//            } else if (pIdx == len - 3) {
//                return Long.valueOf(fixed + "00");
//            } else if (pIdx == len - 4) {
//                return Long.valueOf(fixed + "0");
//            } else {
//                return Long.valueOf(fixed.substring(0, pIdx + 4));
//            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static int yuan2Mini(String yuan) {
        if (yuan == null) {
            return 0;
        }
        try {
            int pIdx = yuan.indexOf(".");
            int len = yuan.length();
            String fixed = yuan.replaceAll("\\.", "");
            if (pIdx < 0 || pIdx == len - 1) {
                return Integer.valueOf(fixed + "0000");
            } else if (pIdx == len - 2) {
                return Integer.valueOf(fixed + "000");
            } else if (pIdx == len - 3) {
                return Integer.valueOf(fixed + "00");
            } else if (pIdx == len - 4) {
                return Integer.valueOf(fixed + "0");
            } else {
                return Integer.valueOf(fixed.substring(0, pIdx + 4));
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static long getRepaymentDiscount(long betFinishFlow, long discountRate, long betflowRate) {
        return betFinishFlow * discountRate / betflowRate;
    }


    public static String moneyToYuan(Long fen) {
        if (fen == null) {
            return "0.00";
        }
        if (fen >= 0) {
            return moneyToYuanForPositive(fen);
        } else {
            return "-" + moneyToYuanForPositive(Math.abs(fen));

        }

    }

    public static String moneyToYuanForPositive(Long fen) {
        if (fen == null) {
            return "0.00";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fen);
        int len = sb.length();
        if (len < 3) {
            for (int i = 0; i < 3 - len; i++) {
                sb.insert(0, "0");
            }
        }
        return sb.insert(sb.length() - 2, ".").toString();
    }
}
