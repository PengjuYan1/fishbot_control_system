package com.jlboat.phone.communication;
public class SpiritServiceClient {

    public SpiritServiceClient()
    {
        return;
    }

    public void addManuPosintServices(long p19, String p21, double p22, double p24, double p26, double p28, double p30, com.boat.jrosbridge.MessageListener p32)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.AddManuPoint, com.jlboat.phone.message.map_msgs.PointManuSetRequest, com.jlboat.phone.message.map_msgs.PointMaunSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PointManuSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.PointManuSetRequest();
        v1_2.setPointName(p21);
        v1_2.setPointMode(p19);
        com.boat.jrosbridge.message.geometry_msgs.Quaternion v5_1 = new com.boat.jrosbridge.message.geometry_msgs.Quaternion();
        v5_1.setW(p28);
        v5_1.setX(0);
        v5_1.setY(0);
        v5_1.setZ(p26);
        com.boat.jrosbridge.message.geometry_msgs.Point v12_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
        v12_1.setX(p22);
        v12_1.setY(p24);
        v12_1.setZ(0);
        com.boat.jrosbridge.MessageListener v2_7 = new com.boat.jrosbridge.message.geometry_msgs.Pose();
        v2_7.setOrientation(v5_1);
        v2_7.setPosition(v12_1);
        com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance v3_3 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance();
        v3_3.setPose(v2_7);
        double[] v4_1 = new double[36];
        v4_1[0] = p30;
        v4_1[1] = 0;
        v4_1[2] = 0;
        v4_1[3] = 0;
        v4_1[4] = 0;
        v4_1[5] = 0;
        v4_1[6] = 0;
        v4_1[7] = 0;
        v4_1[8] = 0;
        v4_1[9] = 0;
        v4_1[10] = 0;
        v4_1[11] = 0;
        v4_1[12] = 0;
        v4_1[13] = 0;
        v4_1[14] = 0;
        v4_1[15] = 0;
        v4_1[16] = 0;
        v4_1[17] = 0;
        v4_1[18] = 0;
        v4_1[19] = 0;
        v4_1[20] = 0;
        v4_1[21] = 0;
        v4_1[22] = 0;
        v4_1[23] = 0;
        v4_1[24] = 0;
        v4_1[25] = 0;
        v4_1[26] = 0;
        v4_1[27] = 0;
        v4_1[28] = 0;
        v4_1[29] = 0;
        v4_1[30] = 0;
        v4_1[31] = 0;
        v4_1[32] = 0;
        v4_1[33] = 0;
        v4_1[34] = 0;
        v4_1[35] = 0;
        v3_3.setCovariance(v4_1);
        com.boat.jrosbridge.message.std_msgs.Header v15_1 = new com.boat.jrosbridge.message.std_msgs.Header();
        v15_1.setFrameId("map");
        com.boat.jrosbridge.MessageListener v2_2 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped();
        v2_2.setHeader(v15_1);
        v2_2.setPose(v3_3);
        v1_2.setPoint(v2_2);
        v0_1.callWithHandler(v1_2, p32);
        return;
    }

    public void addManuPosintServices(long p18, String p20, double p21, double p23, double p25, double p27, com.boat.jrosbridge.MessageListener p29)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.AddManuPoint, com.jlboat.phone.message.map_msgs.PointManuSetRequest, com.jlboat.phone.message.map_msgs.PointMaunSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PointManuSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.PointManuSetRequest();
        v1_2.setPointName(p20);
        v1_2.setPointMode(p18);
        com.boat.jrosbridge.message.geometry_msgs.Quaternion v5_1 = new com.boat.jrosbridge.message.geometry_msgs.Quaternion();
        v5_1.setW(p27);
        v5_1.setX(0);
        v5_1.setY(0);
        v5_1.setZ(p25);
        com.boat.jrosbridge.message.geometry_msgs.Point v12_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
        v12_1.setX(p21);
        v12_1.setY(p23);
        v12_1.setZ(0);
        com.boat.jrosbridge.MessageListener v2_3 = new com.boat.jrosbridge.message.geometry_msgs.Pose();
        v2_3.setOrientation(v5_1);
        v2_3.setPosition(v12_1);
        com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance v3_3 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance();
        v3_3.setPose(v2_3);
        com.boat.jrosbridge.message.std_msgs.Header v4_1 = new com.boat.jrosbridge.message.std_msgs.Header();
        v4_1.setFrameId("map");
        com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped v15_2 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped();
        v15_2.setHeader(v4_1);
        v15_2.setPose(v3_3);
        v1_2.setPoint(v15_2);
        v0_1.callWithHandler(v1_2, p29);
        return;
    }

    public void addOrDelCleanAreaServer(world_canvas_msgs18.SetCleanAreaEnty p9, com.boat.jrosbridge.MessageListener p10)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.CleanAreaService, com.jlboat.phone.message.map_msgs.SetCleanAreaRequest, com.jlboat.phone.message.map_msgs.SetCleanAreaResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetCleanAreaRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetCleanAreaRequest();
        if (p9.getType() != null) {
            v1_2.setType(p9.getType());
        }
        java.util.LinkedList v2_2 = new java.util.LinkedList();
        if ((p9.getPoints() != null) && (p9.getPoints().size() > 0)) {
            java.util.Iterator v3_4 = p9.getPoints().iterator();
            while (v3_4.hasNext()) {
                com.boat.support.slam.entity.floors.Lines v4_3 = ((com.boat.support.slam.entity.floors.Lines) v3_4.next());
                com.boat.jrosbridge.message.geometry_msgs.Point v5_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
                v5_1.setX(v4_3.getX());
                v5_1.setY(v4_3.getY());
                v2_2.add(v5_1);
            }
        }
        v1_2.setPoints(v2_2);
        v1_2.setName(p9.getName());
        v1_2.setRadius(p9.getRadius());
        v1_2.setCleanAreaId(p9.getCleanAreaId());
        v1_2.setClosed(p9.isClosed());
        v0_1.callWithHandler(v1_2, p10);
        return;
    }

    public void addOrDelDiyPath(world_canvas_msgs18.DiyPathEnty p9, com.boat.jrosbridge.MessageListener p10)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DiyPath, com.jlboat.phone.message.map_msgs.SetGlobalPlanRequest, com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetGlobalPlanRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetGlobalPlanRequest();
        com.boat.jrosbridge.message.geometry_msgs.Point[] v2_1 = new com.boat.jrosbridge.message.geometry_msgs.Point[0];
        java.util.List v3_0 = p9.getLinesList();
        if ((v3_0 != null) && (v3_0.size() > 0)) {
            v2_1 = new com.boat.jrosbridge.message.geometry_msgs.Point[p9.getLinesList().size()];
            int v4_3 = 0;
            while (v4_3 < p9.getLinesList().size()) {
                com.boat.jrosbridge.message.geometry_msgs.Point v5_3 = new com.boat.jrosbridge.message.geometry_msgs.Point();
                v5_3.setX(((com.boat.support.slam.entity.floors.Lines) p9.getLinesList().get(v4_3)).getX());
                v5_3.setY(((com.boat.support.slam.entity.floors.Lines) p9.getLinesList().get(v4_3)).getY());
                v2_1[v4_3] = v5_3;
                v4_3++;
            }
        }
        v1_2.setPoints(v2_1);
        v1_2.setDir(p9.getDir());
        v1_2.setGlobalplanName(p9.getGlobalplanName());
        v1_2.setGlobalplanId(p9.getGlobalplanId());
        v1_2.setOp(p9.getOp());
        v0_1.callWithHandler(v1_2, p10);
        return;
    }

    public void addOrDelRegionServer(world_canvas_msgs18.SetRegionRequestEnty p9, com.boat.jrosbridge.MessageListener p10)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RegionService, com.jlboat.phone.message.map_msgs.SetRegionRequest, com.jlboat.phone.message.map_msgs.SetShapeResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetRegionRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetRegionRequest();
        v1_2.setRegionId(p9.getRegionId());
        v1_2.setType(p9.getType());
        v1_2.setStartPointId(p9.getStartPointId());
        v1_2.setEndPointId(p9.getEndPointId());
        v1_2.setWaitPointId(p9.getWaitPointId());
        java.util.LinkedList v2_6 = new java.util.LinkedList();
        if ((p9.getPoints() != null) && (p9.getPoints().size() > 0)) {
            java.util.Iterator v3_5 = p9.getPoints().iterator();
            while (v3_5.hasNext()) {
                com.boat.support.slam.entity.floors.Lines v4_3 = ((com.boat.support.slam.entity.floors.Lines) v3_5.next());
                com.boat.jrosbridge.message.geometry_msgs.Point v5_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
                v5_1.setX(v4_3.getX());
                v5_1.setY(v4_3.getY());
                v2_6.add(v5_1);
            }
        }
        v1_2.setPoints(v2_6);
        v1_2.setRegionProperty2(p9.getRegionProperty2());
        v1_2.setRegionProperty1(p9.getRegionProperty1());
        v0_1.callWithHandler(v1_2, p10);
        return;
    }

    public void addOrDelShapeServer(world_canvas_msgs18.SetShapeRequestEnty p9, com.boat.jrosbridge.MessageListener p10)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.ShapeService, com.jlboat.phone.message.map_msgs.SetShapeRequest, com.jlboat.phone.message.map_msgs.SetShapeResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetShapeRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetShapeRequest();
        if (p9.getType() != null) {
            v1_2.setType(p9.getType());
        }
        java.util.LinkedList v2_2 = new java.util.LinkedList();
        if ((p9.getPoints() != null) && (p9.getPoints().size() > 0)) {
            java.util.Iterator v3_4 = p9.getPoints().iterator();
            while (v3_4.hasNext()) {
                com.boat.support.slam.entity.floors.Lines v4_3 = ((com.boat.support.slam.entity.floors.Lines) v3_4.next());
                com.boat.jrosbridge.message.geometry_msgs.Point v5_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
                v5_1.setX(v4_3.getX());
                v5_1.setY(v4_3.getY());
                v2_2.add(v5_1);
            }
        }
        v1_2.setPoints(v2_2);
        v1_2.setRadius(p9.getRadius());
        v1_2.setShapeId(p9.getShapeId());
        v1_2.setClosed(p9.isClosed());
        v0_1.callWithHandler(v1_2, p10);
        return;
    }

    public void addPointsGlobalplan(world_canvas_msgs18.DiyPathEnty p6, int p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanRequest v1_0;
        if (p7 != 0) {
            v1_0 = com.jlboat.phone.util.ServiceNames.DeletePointsGlobalPlan;
        } else {
            v1_0 = com.jlboat.phone.util.ServiceNames.AddPointsGlobalplan;
        }
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(v1_0, com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanRequest, com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanRequest v1_2 = new com.jlboat.phone.message.map_msgs.AddPointsGlobalPlanRequest();
        v1_2.setGlobalplanId(p6.getGlobalplanId());
        v1_2.setAddPoints(p6.getAddPoint());
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void addPosintServices(long p6, String p8, com.boat.jrosbridge.MessageListener p9)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.AddPoint, com.jlboat.phone.message.map_msgs.PointSetRequest, com.jlboat.phone.message.map_msgs.PointSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PointSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.PointSetRequest();
        v1_2.setPointName(p8);
        v1_2.setPointMode(p6);
        v0_1.callWithHandler(v1_2, p9);
        return;
    }

    public void clearMapService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.ClearMap, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.ClearMapResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void deleteAllMapService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DeleteAllMap, com.jlboat.phone.message.map_msgs.DeleteMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.jlboat.phone.message.map_msgs.DeleteMapRequest(), p6);
        return;
    }

    public void deleteBagService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DeleteAllBags, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.DeleteAllbagsResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void deleteFloorService(long p6, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RenameFloor, com.jlboat.phone.message.map_msgs.DeleteMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.DeleteMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.DeleteMapRequest();
        v1_2.setFloorId(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void deleteLogService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DeleteAlllogs, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.DeleteAlllogsResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void deleteMapService(long p6, long p8, com.boat.jrosbridge.MessageListener p10)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DeleteFloor, com.jlboat.phone.message.map_msgs.DeleteMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.DeleteMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.DeleteMapRequest();
        v1_2.setFloorId(p6);
        v1_2.setMapId(p8);
        v0_1.callWithHandler(v1_2, p10);
        return;
    }

    public void deletePonsintService(long p6, long p8, long p10, com.boat.jrosbridge.MessageListener p12)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.DeleteTestPoint, com.jlboat.phone.message.map_msgs.DeleteTestPointRequest, com.jlboat.phone.message.map_msgs.DeleteTestPointResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.DeleteTestPointRequest v1_2 = new com.jlboat.phone.message.map_msgs.DeleteTestPointRequest();
        v1_2.setFloorId(p6);
        v1_2.setMapId(p8);
        v1_2.setPointId(p10);
        v0_1.callWithHandler(v1_2, p12);
        return;
    }

    public void downLoadMapData(String p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.slamDownMap, com.jlboat.phone.message.map_msgs.ImportConfigSetRequest, com.jlboat.phone.message.map_msgs.ImportConfigSetResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.ImportConfigSetRequest v1_2 = new com.jlboat.phone.message.map_msgs.ImportConfigSetRequest();
        v1_2.setFiles_site(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void executePath(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.ExecutePath, com.jlboat.phone.message.map_msgs.ExecutePathRequest, com.jlboat.phone.message.map_msgs.ExecutePathResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.ExecutePathRequest v1_2 = new com.jlboat.phone.message.map_msgs.ExecutePathRequest();
        v1_2.setOp(((long) p6));
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void getBagListService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.GetBags, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.BagListResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getBuildPointsService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.NaviPoints, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.ListNaviPointsResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getCurrentPositionListener(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.CurrentPosint, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.GetPositionResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getLogService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.GetLogs, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.GetLogResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getMapsService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.GetMaps, com.boat.jrosbridge.message.std_srvs.Empty, com.boat.jrosbridge.message.std_srvs.TriggerResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void getNaviInfoService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.NaviInfo, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.AboutRobotResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void rebuildMapService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RebuildMap, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.message.map_msgs.ClearMapResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.boat.jrosbridge.message.std_srvs.Empty(), p6);
        return;
    }

    public void relocation(double p18, double p20, double p22, double p24, com.boat.jrosbridge.MessageListener p26)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Relocation, com.jlboat.phone.message.map_msgs.SetRelocationRequest, com.jlboat.phone.message.map_msgs.SetRelocationResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetRelocationRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetRelocationRequest();
        com.boat.jrosbridge.MessageListener v2_3 = new com.boat.jrosbridge.message.geometry_msgs.Quaternion();
        v2_3.setW(p24);
        v2_3.setX(0);
        v2_3.setY(0);
        v2_3.setZ(p22);
        com.boat.jrosbridge.message.geometry_msgs.Point v9_1 = new com.boat.jrosbridge.message.geometry_msgs.Point();
        v9_1.setX(p18);
        v9_1.setY(p20);
        v9_1.setZ(0);
        com.boat.jrosbridge.message.geometry_msgs.Pose v5_2 = new com.boat.jrosbridge.message.geometry_msgs.Pose();
        v5_2.setOrientation(v2_3);
        v5_2.setPosition(v9_1);
        com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance v6_1 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance();
        v6_1.setPose(v5_2);
        com.boat.jrosbridge.message.std_msgs.Header v14_1 = new com.boat.jrosbridge.message.std_msgs.Header();
        v14_1.setFrameId("map");
        com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped v15_2 = new com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped();
        v15_2.setHeader(v14_1);
        v15_2.setPose(v6_1);
        v1_2.setPoint(v15_2);
        v0_1.callWithHandler(v1_2, p26);
        return;
    }

    public void renameDiyPath(world_canvas_msgs18.DiyPathEnty p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RenamePath, com.jlboat.phone.message.map_msgs.RenameGlobalplanRequest, com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RenameGlobalplanRequest v1_2 = new com.jlboat.phone.message.map_msgs.RenameGlobalplanRequest();
        v1_2.setDir(p6.getDir());
        v1_2.setGlobalplanName(p6.getGlobalplanName());
        v1_2.setGlobalplanId(p6.getGlobalplanId());
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void renameFloorService(long p6, String p8, com.boat.jrosbridge.MessageListener p9)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RenameFloor, com.jlboat.phone.message.map_msgs.RenameMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RenameMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.RenameMapRequest();
        v1_2.setFloorId(p6);
        v1_2.setNewName(p8);
        v0_1.callWithHandler(v1_2, p9);
        return;
    }

    public void renameMapService(long p6, long p8, String p10, com.boat.jrosbridge.MessageListener p11)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RenameMapName, com.jlboat.phone.message.map_msgs.RenameMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RenameMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.RenameMapRequest();
        v1_2.setFloorId(p6);
        v1_2.setMapId(p8);
        v1_2.setNewName(p10);
        v0_1.callWithHandler(v1_2, p11);
        return;
    }

    public void renamePosintService(int p6, long p7, long p9, long p11, String p13, com.boat.jrosbridge.MessageListener p14)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.RenamePoint, com.jlboat.phone.message.map_msgs.PointRenameRequest, com.jlboat.phone.message.map_msgs.PointRenameResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PointRenameRequest v1_2 = new com.jlboat.phone.message.map_msgs.PointRenameRequest();
        v1_2.setType(p6);
        v1_2.setFloorId(p7);
        v1_2.setMapId(p9);
        v1_2.setPointId(p11);
        v1_2.setNewName(p13);
        v0_1.callWithHandler(v1_2, p14);
        return;
    }

    public void robotSshService(String p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Ssh, com.jlboat.phone.message.map_msgs.RobotSshRequest, com.jlboat.phone.message.map_msgs.RobotSshResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.RobotSshRequest v1_2 = new com.jlboat.phone.message.map_msgs.RobotSshRequest();
        v1_2.setInstruction(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void saveEraseMapService(com.boat.jrosbridge.MessageListener p6)
    {
        new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.saveEraseMap, com.jlboat.phone.message.map_msgs.SaveMapRequest, com.jlboat.phone.message.map_msgs.SaveMapResponse, com.jlboat.phone.application.BoatSlamApplication.client).callWithHandler(new com.jlboat.phone.message.map_msgs.SaveMapRequest(), p6);
        return;
    }

    public void saveMapEXTService(String p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.saveExtMap, com.jlboat.phone.message.map_msgs.SaveMapStringRequest, com.jlboat.phone.message.map_msgs.SaveMapStringResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SaveMapStringRequest v1_2 = new com.jlboat.phone.message.map_msgs.SaveMapStringRequest();
        v1_2.setBase64(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void saveMapService(int p6, long p7, String p9, String p10, com.boat.jrosbridge.MessageListener p11)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.SaveMap, com.jlboat.phone.message.map_msgs.SaveMapRequest, com.jlboat.phone.message.map_msgs.SaveMapResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SaveMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.SaveMapRequest();
        v1_2.setType(p6);
        v1_2.setFloorId(p7);
        v1_2.setFloorName(p9);
        v1_2.setMapName(p10);
        v0_1.callWithHandler(v1_2, p11);
        return;
    }

    public void setChargingPriority(java.util.List p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Chargpriority, com.jlboat.phone.message.map_msgs.SetInt64ArrayRequest, com.jlboat.phone.message.map_msgs.SetInt64ArrayResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetInt64ArrayRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetInt64ArrayRequest();
        long[] v2_0 = new long[p7.size()];
        int v3_0 = 0;
        while (v3_0 < p7.size()) {
            v2_0[v3_0] = ((Long) p7.get(v3_0)).longValue();
            v3_0++;
        }
        v1_2.setData(v2_0);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setCocoNumServiceResponseListener(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.CocoNum, com.jlboat.phone.message.map_msgs.SetCocoNumRequest, com.jlboat.phone.message.map_msgs.SetCocoNumResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetCocoNumRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetCocoNumRequest();
        v1_2.setCocoNum(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void setEraseModeService(int p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.EraserMode, com.jlboat.phone.message.map_msgs.SetEraserModeRequest, com.jlboat.phone.message.map_msgs.SetEraserModeResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetEraserModeRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetEraserModeRequest();
        v1_2.setErasermode(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void setGoalServiceResponseListener(String p6, com.boat.jrosbridge.MessageListener p7)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Goal, com.jlboat.phone.message.map_msgs.SetGoalRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetGoalRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetGoalRequest();
        v1_2.setGoalName(p6);
        v0_1.callWithHandler(v1_2, p7);
        return;
    }

    public void setMoveModeListener(long p6, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Mode, com.jlboat.phone.message.map_msgs.SetModeRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetModeRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetModeRequest();
        v1_2.setMode(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setNaviGoalServiceResponseListener(long p6, long p8, long p10, int p12, com.boat.jrosbridge.MessageListener p13)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.NaviGoal, com.jlboat.phone.message.map_msgs.TargetGoalPlanRequest, com.jlboat.phone.message.map_msgs.TargetGoalPlanResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.TargetGoalPlanRequest v1_2 = new com.jlboat.phone.message.map_msgs.TargetGoalPlanRequest();
        v1_2.setFloorId(p6);
        v1_2.setMapId(p8);
        v1_2.setPointId(p10);
        v1_2.setType(p12);
        v0_1.callWithHandler(v1_2, p13);
        return;
    }

    public void setNaviTestService(java.util.List p6, long p7, com.boat.jrosbridge.MessageListener p9)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.NaviTest, com.jlboat.phone.message.map_msgs.SetNaviTestRequest, com.jlboat.phone.message.map_msgs.SetNaviTestResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetNaviTestRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetNaviTestRequest();
        v1_2.setType(p7);
        if ((p6 != null) && (!p6.isEmpty())) {
            Object v3_0 = p6.get(0);
            if (!(v3_0 instanceof String)) {
                if ((v3_0 instanceof com.boat.support.slam.entity.floors.NaviTest)) {
                    com.boat.support.slam.entity.floors.NaviTest[] v2_3 = new com.boat.support.slam.entity.floors.NaviTest[0];
                    v1_2.setNaviTests(((com.boat.support.slam.entity.floors.NaviTest[]) p6.toArray(v2_3)));
                }
            } else {
                v1_2.setGoalNames(p6);
            }
        }
        v0_1.callWithHandler(v1_2, p9);
        return;
    }

    public void setNavicmdListener(String p6, long p7, com.boat.jrosbridge.MessageListener p9)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Navicmd, com.jlboat.phone.message.map_msgs.SetNaviCmdRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetNaviCmdRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetNaviCmdRequest();
        v1_2.setCmd(p6);
        v1_2.setDistance(p7);
        v0_1.callWithHandler(v1_2, p9);
        return;
    }

    public void setPublishService(int p6, long p7, long p9, com.boat.jrosbridge.MessageListener p11)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.ChangeMap, com.jlboat.phone.message.map_msgs.PublishMapRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PublishMapRequest v1_2 = new com.jlboat.phone.message.map_msgs.PublishMapRequest();
        v1_2.setType(p6);
        v1_2.setFloorId(p7);
        v1_2.setMapId(p9);
        v0_1.callWithHandler(v1_2, p11);
        return;
    }

    public void setScaleTestService(int p6, int p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.MoveCalibration, com.jlboat.phone.message.map_msgs.ScaleTestRequest, com.jlboat.phone.message.map_msgs.ScaleTestResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.ScaleTestRequest v1_2 = new com.jlboat.phone.message.map_msgs.ScaleTestRequest();
        v1_2.setType(p7);
        v1_2.setValue(p6);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void setWifiServiceResponseListener(String p6, String p7, com.boat.jrosbridge.MessageListener p8)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.Wifi, com.jlboat.phone.message.map_msgs.SetWifiRequest, com.boat.jrosbridge.message.std_srvs.Empty, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.SetWifiRequest v1_2 = new com.jlboat.phone.message.map_msgs.SetWifiRequest();
        v1_2.setWifiName(p6);
        v1_2.setWifiPass(p7);
        v0_1.callWithHandler(v1_2, p8);
        return;
    }

    public void updatePointService(int p6, long p7, long p9, long p11, String p13, com.boat.jrosbridge.MessageListener p14)
    {
        com.boat.jrosbridge.Service v0_1 = new com.boat.jrosbridge.Service(com.jlboat.phone.util.ServiceNames.UpdatePoint, com.jlboat.phone.message.map_msgs.PointUpdateRequest, com.jlboat.phone.message.map_msgs.PointUpdateResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.jlboat.phone.message.map_msgs.PointUpdateRequest v1_2 = new com.jlboat.phone.message.map_msgs.PointUpdateRequest();
        v1_2.setType(p6);
        v1_2.setFloorId(p7);
        v1_2.setMapId(p9);
        v1_2.setPointId(p11);
        v1_2.setData(p13);
        v0_1.callWithHandler(v1_2, p14);
        return;
    }
}
