package com.jlboat.phone.communication;
public class SpiritTopicListener {

    public SpiritTopicListener()
    {
        return;
    }

    public void getAutoChargeStatusMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.GoCharge, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getBatteryMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.BatteryMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getBattry(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.Battry, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getCameraMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.CameraMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getChageMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.ChageMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getChangeMotionMode(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.ChNgeMotionMode, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getEMEMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.EMEMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getHeartMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.HeartMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getImuMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.ImuMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getInitMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.InitMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getLeftMotorMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.LeftMotorMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getLidarMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.LidarMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getLocationMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.LocationMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMOROTMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.MOROTMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMapBuildStatusMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.MapBuildStatusMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMapStatus(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.MapStatus, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMapStatusMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.MapStatusMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMotor1Msg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.Motor1Msg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMotor2Msg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.Motor2Msg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getMoveTestMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.MoveTestMsg, com.boat.jrosbridge.message.std_msgs.Float32, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviNetworkMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviNetworkMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviStopMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviStop, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviTargetGoal(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.naviTargetgoal, com.jlboat.phone.message.map_msgs.TargetGoal, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviTargetgoalList(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NAVI_TARGET_GOAL_LIST, com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviToPointName(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviToPointName, com.jlboat.phone.message.map_msgs.SetTargetGoal, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNaviWait(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.TARGET_GOAL_WAIT_TIME, com.boat.jrosbridge.message.std_msgs.Int32, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getNavigationMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NavigationMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getOdomMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.OdomMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getOutChangeStatus(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.OUTOFCHARGE_STATUS, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getOutChargeMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.OutChargeMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getOutMachineSignal(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.REVICE_OUTMACHINE_SIGNAL, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getRightMotorMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.RightMotorMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getSonarMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.SonarMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getStm32Msg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.Stm32Msg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getTestMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.TestMsg, com.jlboat.phone.message.map_msgs.NaviTestResultEntrys, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getVirtualMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.VirtualMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void getWallUpdateMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.WallUpdateMsg, com.boat.jrosbridge.message.std_msgs.Int32, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }

    public void onStart()
    {
        return;
    }

    public void onStop()
    {
        return;
    }

    public void slamDownMapStateMsg(com.boat.jrosbridge.MessageListener p5)
    {
        new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.DownMapStateMsg, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client).subscribe(p5);
        return;
    }
}
