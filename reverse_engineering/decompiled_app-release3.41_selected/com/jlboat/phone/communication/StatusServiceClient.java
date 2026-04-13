package com.jlboat.phone.communication;
public class StatusServiceClient {

    public StatusServiceClient()
    {
        return;
    }

    public void getConfigsService(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotConfig, com.jlboat.phone.message.map_msgs.GetConfigsRequest, com.jlboat.phone.message.map_msgs.GetConfigsResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.GetConfigsRequest v1_2 = new com.jlboat.phone.message.map_msgs.GetConfigsRequest();
        v1_2.setType(p6);
        com.jlboat.phone.application.BoatSlamApplication.client.setDebug(1);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void getCreamService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotCream, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.NavigationCreamSetListResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getEspStatusService(com.boat.jrosbridge.MessageListener p6)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.GetESPStatus, com.jlboat.phone.message.map_msgs.SetInt64Request, com.jlboat.phone.message.map_msgs.SetInt64Response, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetInt64Request v1_2 = new com.jlboat.phone.message.map_msgs.SetInt64Request();
        v1_2.setData(1);
        v0_1.callWithHandler(v1_2, p6);
        return;
    }

    public void getLoraStatusService(com.boat.jrosbridge.MessageListener p6)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.GetLoraStatus, com.jlboat.phone.message.map_msgs.SetInt64Request, com.jlboat.phone.message.map_msgs.SetInt64Response, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetInt64Request v1_2 = new com.jlboat.phone.message.map_msgs.SetInt64Request();
        v1_2.setData(1);
        v0_1.callWithHandler(v1_2, p6);
        return;
    }

    public void getSfaeService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSafe, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.NavigationSafeSetListResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getSonarService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSonar, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.RobotSonarListResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getSpeedService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSpeed, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.RobotSpeedListResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void setCalculateOdomService(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.CalculateOdom, com.jlboat.phone.message.map_msgs.CalculateOdomRequest, com.jlboat.phone.message.map_msgs.CalculateOdomResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.CalculateOdomRequest v1_2 = new com.jlboat.phone.message.map_msgs.CalculateOdomRequest();
        v1_2.setCmd(((long) p6));
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void setCreamService(long p6, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotCreamSet, com.jlboat.phone.message.map_msgs.NavigationCreamSetRequest, com.jlboat.phone.message.map_msgs.NavigationCreamSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.NavigationCreamSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.NavigationCreamSetRequest();
        v1_2.setOp(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setOrDelConfigsService(java.util.List p6, int p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotConfigSet, com.jlboat.phone.message.map_msgs.SetConfigsRequest, com.jlboat.phone.message.map_msgs.SetConfigsResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetConfigsRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetConfigsRequest();
        v1_2.setType(p7);
        v1_2.setConfigs(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setSfaeService(long p6, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSafeSet, com.jlboat.phone.message.map_msgs.NavigationSafeSetRequest, com.jlboat.phone.message.map_msgs.NavigationSafeSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.NavigationSafeSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.NavigationSafeSetRequest();
        v1_2.setOp(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setSonarService(java.util.List p6, boolean p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSonarSet, com.jlboat.phone.message.map_msgs.RobotSonarSetRequest, com.jlboat.phone.message.map_msgs.RobotSonarSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RobotSonarSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.RobotSonarSetRequest();
        v1_2.setSonars(p6);
        v1_2.setUserSonar(p7);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setSpeedService(long p6, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotSpeedSet, com.jlboat.phone.message.map_msgs.RobotSpeedSetRequest, com.jlboat.phone.message.map_msgs.RobotSpeedSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RobotSpeedSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.RobotSpeedSetRequest();
        v1_2.setSpeed(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setTestDriverService(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.robotTestDriver, com.jlboat.phone.message.map_msgs.TestDriverRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.TestDriverRequest v1_2 = new com.jlboat.phone.message.map_msgs.TestDriverRequest();
        v1_2.setCmd(((long) p6));
        v0_1.callWithHandler(v1_2, p7);
        return;
    }
}
