package com.max.client.controller;//package com.max.forehead.controller;
//
//import com.max.activity.service.ActivityOrderService;
//import com.max.activity.service.ActivityService;
//import com.max.app.service.AppMaintainService;
//import com.max.app.service.AppService;
//import com.max.core.redis.RedisService;
//import com.max.core.result.Result;
//import com.max.forehead.dto.GameDto;
//import com.max.forehead.utils.IpUtil;
//import com.max.game.dto.GameDto;
//import com.max.game.service.GameService;
//import com.max.game.service.GameViewService;
//import com.max.transfer.service.TransferOrderService;
//import com.max.transfer.service.TransferService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class GameController {
//    @Autowired
//    private GameService gameService;
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private TransferService transferService;
//    @Autowired
//    private TransferOrderService transferOrderService;
//    @Autowired
//    private GameViewService gameViewrService;
//    @Autowired
//    private AppService appService;
//    @Autowired
//    private AppMaintainService appMaintainService;
//
//
//    /*游戏视图*/
//    @PostMapping("/game")
//    public Result game(){
//        //平台：维护，分类：顺序 游戏：顺序，维护
//        String ip = IpUtil.getIpAddr();return null;
//    }
//    /*额度转入游戏*/
//    @PostMapping("/transferin")
//    public GameDto transferin(GameDto game){
//        //事务：比较钱包余额足够，扣除钱包余额，生成游戏转入单
//        //事务：转入失败，返回钱包余额
//        //事务：转入成功，记录钱包增减日志
//        String ip = IpUtil.getIpAddr();return null;
//    }
//    /*额度转出游戏*/
//    @PostMapping("/transferout")
//    public GameDto transferout(GameDto game){
//        //事务：比较游戏余额足够，生成游戏转出单，发起游戏余额转出
//        //事务：转出失败
//        //事务：转出成功，记录钱包增减日志，钱包增加相应额度
//        String ip = IpUtil.getIpAddr();return null;
//    }
//    /*进入游戏*/
//    @PostMapping("/enter")
//    public GameDto enter(GameDto game){
//        //用户是否有效
//        //创建游戏账号
//        //额度转入游戏
//        //登录游戏
//        String ip = IpUtil.getIpAddr();return null;
//    }
//    /*查看投注情况*/
//    @PostMapping("/gamerecord")
//    public GameDto gamerecord(GameDto recordPage){
//        //用户是否有效
//        //获取筛选的投注记录。最大一个月
//        String ip = IpUtil.getIpAddr();return null;
//    }
//}
