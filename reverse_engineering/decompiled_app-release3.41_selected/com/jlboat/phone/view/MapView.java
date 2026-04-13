package com.jlboat.phone.view;
public class MapView extends android.view.View {
    private static final int COLOR_UNKNOWN = 15397370;
    private static final int DEFAULT_BITMAP = 0;
    private static final String TAG = "MapView";
    private android.graphics.Paint bitmapPaint;
    private int bitmap_height;
    private int bitmap_width;
    private android.graphics.Paint circleDelPaint;
    private android.graphics.Paint circleFillPaint;
    private android.graphics.Paint circlePaint;
    private java.util.List cleanAreas;
    private android.graphics.Paint cleanAreasPaint;
    private android.graphics.Paint cleanPathPaint;
    private boolean cleanPathReady;
    private com.boat.jrosbridge.Topic cleanPathSubscriber;
    private java.util.List cleanPathpoints;
    private long clickTime;
    com.jlboat.phone.util.ROSColor colorHigh;
    com.jlboat.phone.util.ROSColor colorLow;
    private int[] colorMap;
    private int currentStatus;
    private long delateShapeId;
    android.graphics.DrawFilter drawFilter;
    private com.boat.support.slam.entity.floors.Points enablePoint;
    private android.graphics.PointF enablePointF;
    private android.graphics.Paint globalPlansPaint;
    private boolean hasEnablePoint;
    private boolean hasPose;
    private boolean hasResponseLongClickEvent;
    private boolean isAutoPoint;
    private boolean isClose;
    private boolean isEdit;
    private boolean isRobot;
    private boolean isScreenMode;
    private boolean isShowId;
    private boolean isUpOut;
    private boolean isbuild;
    private boolean ishuizhiMap;
    private int ize;
    private com.boat.jrosbridge.message.geometry_msgs.Point leftBootmPoint;
    private java.util.List linesListStyle;
    private android.graphics.Paint linesStylePaint;
    private final int longTime;
    private android.graphics.Paint lowScanPaint;
    private com.boat.base.BaseApplication mApp;
    private java.util.List mGlobalPlans;
    private com.boat.jrosbridge.Topic mapSubscriber;
    private boolean map_ready;
    private android.graphics.Paint markerDelPaint;
    private android.graphics.Paint markerFillPaint;
    private android.graphics.Paint markerPaint;
    private android.graphics.Paint markerTextPaint;
    private com.jlboat.phone.view.MapView$MoveCallBackLines moveCallBackLines;
    private final Object mutex;
    private com.jlboat.phone.view.MapView$PathCallBack navigationPathListen;
    private android.graphics.Paint ngLinePaint;
    private android.graphics.Paint ngLineSelectPaint;
    private android.graphics.Paint ngLineTextPaint;
    private long ngNlineID;
    private java.util.List ngNlineList;
    private float origin_for_pixe_x;
    private float origin_for_pixe_y;
    private android.graphics.Paint pathPaint;
    private boolean path_ready;
    private com.boat.jrosbridge.Topic pathlayer;
    private java.util.List pixeMarksList;
    private android.graphics.Paint pointPaint;
    private android.graphics.Paint pointPaintCheck;
    private android.graphics.Paint pointWaitPaint;
    private java.util.List points;
    private final Object poseMutex;
    private java.util.List posintLists;
    android.graphics.PointF posintPointF;
    android.graphics.PointF posintWaitPointF;
    private java.util.Timer publisherTimer;
    private android.graphics.Paint regionFillPaint;
    private java.util.List regionList;
    private android.graphics.Paint regionPaint;
    private android.graphics.Paint regionTextPaint;
    private float resolution;
    android.graphics.PointF robotLPF;
    private com.boat.ros.geometry.Quaternion robotOrientation;
    android.graphics.Path robotPath;
    android.graphics.PointF robotPointF;
    private com.boat.ros.geometry.Vector3 robotPose;
    private com.boat.ros.geometry.Vector3 rotatedP1;
    private com.boat.ros.geometry.Vector3 rotatedP2;
    private com.boat.ros.geometry.Vector3 rotatedP3;
    private com.boat.ros.geometry.Vector3 rotatedP4;
    private float[] scan;
    float[] scanFloats;
    private android.graphics.Paint scanPaint;
    android.graphics.Path scanPath;
    android.graphics.PointF scanPointF;
    private com.boat.jrosbridge.Topic scanPoseSub;
    private double scan_offset_x;
    private double scan_offset_y;
    private double scan_offset_z;
    private boolean scan_ready;
    private long selectRegionId;
    private android.graphics.Paint selectedGlobalPlansPaint;
    private long selectedGpId;
    private java.util.List shapeAreas;
    private android.graphics.Bitmap sourceBitmap;
    private int stride;
    private com.boat.jrosbridge.Topic subscriber;
    private com.jlboat.phone.view.TouchEvenHandler touchEvenHandler;
    private com.boat.jrosbridge.Topic tracked_pose_scriber;
    private boolean useCleanPath;
    com.boat.ros.geometry.Vector3 vector;
    private java.util.List vectorScan;
    com.boat.ros.geometry.Vector3 vectorleft;
    com.boat.ros.geometry.Vector3 vectorright;
    com.boat.ros.geometry.Vector3 vectortop;

    public MapView(android.content.Context p19)
    {
        void v18_1 = super(p19);
        super.ize = 10;
        super.longTime = 800;
        super.isUpOut = 0;
        super.hasResponseLongClickEvent = 0;
        super.clickTime = 0;
        super.colorLow = com.jlboat.phone.util.ROSColor.fromHex("ffffffff");
        super.colorHigh = com.jlboat.phone.util.ROSColor.fromHex("ff147ff9");
        super.isbuild = 1;
        super.vectorScan = new java.util.concurrent.CopyOnWriteArrayList();
        super.stride = 1;
        super.posintLists = new java.util.concurrent.CopyOnWriteArrayList();
        super.pixeMarksList = new java.util.LinkedList();
        super.shapeAreas = new java.util.LinkedList();
        super.isScreenMode = 1;
        super.isClose = 0;
        super.regionList = new java.util.LinkedList();
        super.mGlobalPlans = new java.util.LinkedList();
        super.points = 0;
        super.cleanAreas = new java.util.LinkedList();
        super.ngNlineID = -1;
        super.isAutoPoint = 0;
        super.hasEnablePoint = 0;
        super.isShowId = 0;
        super.isRobot = 0;
        android.graphics.PaintFlagsDrawFilter v2_13 = new com.boat.ros.geometry.Vector3;
        v2_13(0, 0, 0);
        super.vector = v2_13;
        android.graphics.PaintFlagsDrawFilter v2_14 = new com.boat.ros.geometry.Vector3;
        v2_14(-4626637969190257951, 4596734067664517857, 0);
        super.vectorleft = v2_14;
        android.graphics.PaintFlagsDrawFilter v2_15 = new com.boat.ros.geometry.Vector3;
        v2_15(4599075939470750515, 0, 0);
        super.vectortop = v2_15;
        android.graphics.PaintFlagsDrawFilter v2_16 = new com.boat.ros.geometry.Vector3;
        v2_16(-4626998257160447590, -4626998257160447590, 0);
        super.vectorright = v2_16;
        super.drawFilter = new android.graphics.PaintFlagsDrawFilter(0, 3);
        super.scan_offset_x = 4598535507708739584;
        super.scan_offset_y = 0;
        super.scan_offset_z = 0;
        v18_1.createColorMap().creatMarkerPaint().creatRegionPaint().createCleanAreasPaint().createCleanPathPaint().creatScanPaint().creatPathPaint().createPathPaint().createPointWaitPaint().createPathPaintCheck().createNgLinePaint();
        super.mutex = new Object();
        super.poseMutex = new Object();
        return;
    }

    public MapView(android.content.Context p19, android.util.AttributeSet p20)
    {
        void v18_1 = super(p19, p20);
        super.ize = 10;
        super.longTime = 800;
        super.isUpOut = 0;
        super.hasResponseLongClickEvent = 0;
        super.clickTime = 0;
        super.colorLow = com.jlboat.phone.util.ROSColor.fromHex("ffffffff");
        super.colorHigh = com.jlboat.phone.util.ROSColor.fromHex("ff147ff9");
        super.isbuild = 1;
        super.vectorScan = new java.util.concurrent.CopyOnWriteArrayList();
        super.stride = 1;
        super.posintLists = new java.util.concurrent.CopyOnWriteArrayList();
        super.pixeMarksList = new java.util.LinkedList();
        super.shapeAreas = new java.util.LinkedList();
        super.isScreenMode = 1;
        super.isClose = 0;
        super.regionList = new java.util.LinkedList();
        super.mGlobalPlans = new java.util.LinkedList();
        super.points = 0;
        super.cleanAreas = new java.util.LinkedList();
        super.ngNlineID = -1;
        super.isAutoPoint = 0;
        super.hasEnablePoint = 0;
        super.isShowId = 0;
        super.isRobot = 0;
        android.graphics.PaintFlagsDrawFilter v2_13 = new com.boat.ros.geometry.Vector3;
        v2_13(0, 0, 0);
        super.vector = v2_13;
        android.graphics.PaintFlagsDrawFilter v2_14 = new com.boat.ros.geometry.Vector3;
        v2_14(-4626637969190257951, 4596734067664517857, 0);
        super.vectorleft = v2_14;
        android.graphics.PaintFlagsDrawFilter v2_15 = new com.boat.ros.geometry.Vector3;
        v2_15(4599075939470750515, 0, 0);
        super.vectortop = v2_15;
        android.graphics.PaintFlagsDrawFilter v2_16 = new com.boat.ros.geometry.Vector3;
        v2_16(-4626998257160447590, -4626998257160447590, 0);
        super.vectorright = v2_16;
        super.drawFilter = new android.graphics.PaintFlagsDrawFilter(0, 3);
        super.scan_offset_x = 4598535507708739584;
        super.scan_offset_y = 0;
        super.scan_offset_z = 0;
        v18_1.createColorMap().creatMarkerPaint().creatRegionPaint().createCleanAreasPaint().createCleanPathPaint().creatScanPaint().creatPathPaint().createPathPaint().createPointWaitPaint().createPathPaintCheck().createNgLinePaint();
        super.mutex = new Object();
        super.poseMutex = new Object();
        return;
    }

    static synthetic int access$000(com.jlboat.phone.view.MapView p1)
    {
        return p1.ize;
    }

    static synthetic int access$002(com.jlboat.phone.view.MapView p0, int p1)
    {
        p0.ize = p1;
        return p1;
    }

    static synthetic int access$010(com.jlboat.phone.view.MapView p2)
    {
        int v0 = p2.ize;
        p2.ize = (v0 - 1);
        return v0;
    }

    static synthetic com.boat.base.BaseApplication access$100(com.jlboat.phone.view.MapView p1)
    {
        return p1.mApp;
    }

    static synthetic com.boat.ros.geometry.Quaternion access$1000(com.jlboat.phone.view.MapView p1)
    {
        return p1.robotOrientation;
    }

    static synthetic com.boat.ros.geometry.Quaternion access$1002(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Quaternion p1)
    {
        p0.robotOrientation = p1;
        return p1;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$1102(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Vector3 p1)
    {
        p0.rotatedP1 = p1;
        return p1;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$1202(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Vector3 p1)
    {
        p0.rotatedP2 = p1;
        return p1;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$1302(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Vector3 p1)
    {
        p0.rotatedP3 = p1;
        return p1;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$1402(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Vector3 p1)
    {
        p0.rotatedP4 = p1;
        return p1;
    }

    static synthetic boolean access$1502(com.jlboat.phone.view.MapView p0, boolean p1)
    {
        p0.hasPose = p1;
        return p1;
    }

    static synthetic boolean access$1602(com.jlboat.phone.view.MapView p0, boolean p1)
    {
        p0.path_ready = p1;
        return p1;
    }

    static synthetic java.util.List access$1700(com.jlboat.phone.view.MapView p1)
    {
        return p1.points;
    }

    static synthetic java.util.List access$1702(com.jlboat.phone.view.MapView p0, java.util.List p1)
    {
        p0.points = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.view.MapView$PathCallBack access$1800(com.jlboat.phone.view.MapView p1)
    {
        return p1.navigationPathListen;
    }

    static synthetic java.util.List access$1900(com.jlboat.phone.view.MapView p1)
    {
        return p1.cleanPathpoints;
    }

    static synthetic java.util.List access$1902(com.jlboat.phone.view.MapView p0, java.util.List p1)
    {
        p0.cleanPathpoints = p1;
        return p1;
    }

    static synthetic void access$200(com.jlboat.phone.view.MapView p0, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p1)
    {
        p0.updateMapBase64(p1);
        return;
    }

    static synthetic boolean access$2002(com.jlboat.phone.view.MapView p0, boolean p1)
    {
        p0.cleanPathReady = p1;
        return p1;
    }

    static synthetic void access$300(com.jlboat.phone.view.MapView p0, com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p1)
    {
        p0.updateMap(p1);
        return;
    }

    static synthetic double access$402(com.jlboat.phone.view.MapView p0, double p1)
    {
        p0.scan_offset_x = p1;
        return p1;
    }

    static synthetic double access$502(com.jlboat.phone.view.MapView p0, double p1)
    {
        p0.scan_offset_y = p1;
        return p1;
    }

    static synthetic int access$600(com.jlboat.phone.view.MapView p1)
    {
        return p1.stride;
    }

    static synthetic void access$700(com.jlboat.phone.view.MapView p0, com.boat.jrosbridge.message.sensor_msgs.LaserScan p1, int p2)
    {
        p0.updateVertexBuffer(p1, p2);
        return;
    }

    static synthetic Object access$800(com.jlboat.phone.view.MapView p1)
    {
        return p1.mutex;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$900(com.jlboat.phone.view.MapView p1)
    {
        return p1.robotPose;
    }

    static synthetic com.boat.ros.geometry.Vector3 access$902(com.jlboat.phone.view.MapView p0, com.boat.ros.geometry.Vector3 p1)
    {
        p0.robotPose = p1;
        return p1;
    }

    private void creatMarkerPaint()
    {
        this.markerPaint = new android.graphics.Paint();
        this.markerPaint.setTextSize(1120403456);
        this.markerPaint.setColor(this.getResources().getColor(2131034188));
        this.markerPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.markerPaint.setStrokeWidth(1077936128);
        this.markerTextPaint = new android.graphics.Paint();
        this.markerTextPaint.setTextSize(1108082688);
        this.markerTextPaint.setColor(this.getResources().getColor(2131034188));
        this.markerFillPaint = new android.graphics.Paint();
        this.markerFillPaint.setTextSize(1120403456);
        this.markerFillPaint.setColor(this.getResources().getColor(2131034189));
        this.markerFillPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.markerFillPaint.setStrokeWidth(1077936128);
        this.linesStylePaint = new android.graphics.Paint();
        this.linesStylePaint.setTextSize(1120403456);
        this.linesStylePaint.setColor(-65536);
        this.linesStylePaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.linesStylePaint.setStrokeWidth(1077936128);
        this.markerDelPaint = new android.graphics.Paint();
        this.markerDelPaint.setTextSize(1120403456);
        this.markerDelPaint.setColor(-65536);
        this.markerDelPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.markerDelPaint.setStrokeWidth(1077936128);
        this.circlePaint = new android.graphics.Paint();
        this.circlePaint.setColor(this.getResources().getColor(2131034188));
        this.circlePaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.circlePaint.setStrokeWidth(1077936128);
        this.circleFillPaint = new android.graphics.Paint();
        this.circleFillPaint.setColor(this.getResources().getColor(2131034189));
        this.circleFillPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.circleFillPaint.setStrokeWidth(1077936128);
        this.circleDelPaint = new android.graphics.Paint();
        this.circleDelPaint.setColor(-65536);
        this.circleDelPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.circleDelPaint.setStrokeWidth(1077936128);
        this.globalPlansPaint = new android.graphics.Paint();
        this.globalPlansPaint.setTextSize(1120403456);
        this.globalPlansPaint.setColor(android.graphics.Color.parseColor("#4a0476"));
        this.globalPlansPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.globalPlansPaint.setStrokeWidth(1084227584);
        this.selectedGlobalPlansPaint = new android.graphics.Paint();
        this.selectedGlobalPlansPaint.setTextSize(1120403456);
        this.selectedGlobalPlansPaint.setColor(-65536);
        this.selectedGlobalPlansPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.selectedGlobalPlansPaint.setStrokeWidth(1088421888);
        return;
    }

    private void creatPathPaint()
    {
        this.pathPaint = new android.graphics.Paint();
        this.pathPaint.setColor(this.getResources().getColor(2131034165));
        return;
    }

    private void creatRegionPaint()
    {
        this.regionPaint = new android.graphics.Paint();
        this.regionPaint.setTextSize(1108082688);
        this.regionPaint.setColor(this.getResources().getColor(2131034241));
        this.regionPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.regionPaint.setStrokeWidth(1077936128);
        this.regionTextPaint = new android.graphics.Paint();
        this.regionTextPaint.setTextSize(1108082688);
        this.regionTextPaint.setColor(this.getResources().getColor(2131034241));
        this.regionFillPaint = new android.graphics.Paint();
        this.regionFillPaint.setTextSize(1108082688);
        this.regionFillPaint.setColor(this.getResources().getColor(2131034242));
        this.regionFillPaint.setStyle(android.graphics.Paint$Style.FILL);
        this.regionFillPaint.setStrokeWidth(1077936128);
        return;
    }

    private void creatScanPaint()
    {
        this.scanPaint = new android.graphics.Paint();
        this.lowScanPaint = new android.graphics.Paint();
        this.lowScanPaint.setColor(this.getResources().getColor(2131034187));
        this.scanPaint.setColor(this.getResources().getColor(2131034221));
        this.scanPaint.setAntiAlias(1);
        this.scanPaint.setStrokeWidth(1092616192);
        return;
    }

    private void createCleanAreasPaint()
    {
        this.cleanAreasPaint = new android.graphics.Paint();
        this.cleanAreasPaint.setTextSize(1120403456);
        this.cleanAreasPaint.setColor(this.getResources().getColor(2131034162));
        this.cleanAreasPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.cleanAreasPaint.setStrokeWidth(1077936128);
        return;
    }

    private void createCleanPathPaint()
    {
        this.cleanPathPaint = new android.graphics.Paint();
        this.cleanPathPaint.setTextSize(1120403456);
        this.cleanPathPaint.setColor(this.getResources().getColor(2131034175));
        this.cleanPathPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.cleanPathPaint.setStrokeWidth(1077936128);
        return;
    }

    private void createColorMap()
    {
        this.bitmapPaint = new android.graphics.Paint();
        this.bitmapPaint.setColor(-65536);
        this.bitmapPaint.setTextSize(1109393408);
        this.currentStatus = 0;
        int v1_0 = new int[101];
        this.colorMap = v1_0;
        int v1_1 = 0;
        while (v1_1 < 101) {
            this.colorMap[v1_1] = this.colorLow.interpolate(this.colorHigh, (((float) v1_1) / 1120534528)).toInt();
            v1_1++;
        }
        return;
    }

    private void createNgLinePaint()
    {
        this.ngLinePaint = new android.graphics.Paint();
        this.ngLinePaint.setColor(this.getResources().getColor(2131034149));
        this.ngLinePaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.ngLinePaint.setStrokeWidth(1077936128);
        this.ngLineTextPaint = new android.graphics.Paint();
        this.ngLineTextPaint.setTextSize(1112014848);
        this.ngLineTextPaint.setColor(this.getResources().getColor(2131034149));
        this.ngLineSelectPaint = new android.graphics.Paint();
        this.ngLineSelectPaint.setTextSize(1112014848);
        this.ngLineSelectPaint.setColor(this.getResources().getColor(2131034138));
        this.ngLineSelectPaint.setStyle(android.graphics.Paint$Style.STROKE);
        this.ngLineSelectPaint.setStrokeWidth(1077936128);
        return;
    }

    private void createPathPaint()
    {
        this.pointPaint = new android.graphics.Paint();
        this.pointPaint.setColor(this.getResources().getColor(2131034175));
        this.pointPaint.setTextSize(1108082688);
        return;
    }

    private void createPathPaintCheck()
    {
        this.pointPaintCheck = new android.graphics.Paint();
        this.pointPaintCheck.setColor(this.getResources().getColor(2131034138));
        this.pointPaintCheck.setStyle(android.graphics.Paint$Style.STROKE);
        this.pointPaintCheck.setStrokeWidth(1084227584);
        return;
    }

    private void createPointWaitPaint()
    {
        this.pointWaitPaint = new android.graphics.Paint();
        this.pointWaitPaint.setColor(this.getResources().getColor(2131034176));
        this.pointWaitPaint.setTextSize(1106247680);
        return;
    }

    private double lineSpace(double p9, double p11, double p13, double p15)
    {
        return Math.sqrt((((p9 - p13) * (p9 - p13)) + ((p11 - p15) * (p11 - p15))));
    }

    private double pointToLine(double p16, double p18, double p20, double p22, double p24, double p26)
    {
        return this.pointToLine(p16, p18, p20, p22, p24, p26, 4517329193108106637);
    }

    private double pointToLine(double p17, double p19, double p21, double p23, double p25, double p27, double p29)
    {
        double v2_1 = this.lineSpace(p21, p23, p25, p27);
        double v4_0 = this.lineSpace(p21, p23, p17, p19);
        double v6_1 = this.lineSpace(p25, p27, p17, p19);
        if ((v6_1 > p29) && (v4_0 > p29)) {
            if (v2_1 > p29) {
                if ((v6_1 * v6_1) < ((v2_1 * v2_1) + (v4_0 * v4_0))) {
                    if ((v4_0 * v4_0) < ((v2_1 * v2_1) + (v6_1 * v6_1))) {
                        double v8_7 = (((v2_1 + v4_0) + v6_1) / 4611686018427387904);
                        return ((4611686018427387904 * Math.sqrt(((((v8_7 - v2_1) * v8_7) * (v8_7 - v4_0)) * (v8_7 - v6_1)))) / v2_1);
                    } else {
                        return v6_1;
                    }
                } else {
                    return v4_0;
                }
            } else {
                return v4_0;
            }
        } else {
            return 0;
        }
    }

    private void updateMap(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p17)
    {
        float v1_1 = p17.getInfo().getResolution();
        int v2_1 = p17.getInfo().getWidth();
        int v11 = p17.getInfo().getHeight();
        this.resolution = v1_1;
        this.bitmap_width = v2_1;
        this.bitmap_height = v11;
        this.leftBootmPoint = p17.getInfo().getOrigin().getPosition();
        this.origin_for_pixe_x = (0 - ((float) (this.leftBootmPoint.getX() / ((double) v1_1))));
        this.origin_for_pixe_y = (((float) this.bitmap_height) + ((float) (this.leftBootmPoint.getY() / ((double) v1_1))));
        byte[] v12 = p17.getData();
        int[] v13 = new int[(v2_1 * v11)];
        int v4_7 = v12.length;
        int v14 = 0;
        com.jlboat.phone.view.TouchEvenHandler v3_1 = 0;
        while (v3_1 < v4_7) {
            int v6_1 = v12[v3_1];
            if (v6_1 != -1) {
                v13[v14] = this.colorMap[v6_1];
            } else {
                v13[v14] = -1379846;
            }
            v14++;
            v3_1++;
        }
        int[] v15 = new int[(v2_1 * v11)];
        com.jlboat.phone.view.TouchEvenHandler v3_15 = 0;
        int v4_0 = 0;
        while (v3_15 < v11) {
            int v6_0 = 0;
            while (v6_0 < v2_1) {
                if (v4_0 >= v13.length) {
                    v15[((((v11 - 1) - v3_15) * v2_1) + v6_0)] = 0;
                } else {
                    v15[((((v11 - 1) - v3_15) * v2_1) + v6_0)] = v13[v4_0];
                }
                v6_0++;
                v4_0++;
            }
            v3_15++;
        }
        this.sourceBitmap = android.graphics.Bitmap.createBitmap(v2_1, v11, android.graphics.Bitmap$Config.ARGB_8888);
        this.sourceBitmap.setWidth(v2_1);
        this.sourceBitmap.setHeight(v11);
        this.sourceBitmap.setPixels(v15, 0, v2_1, 0, 0, v2_1, v11);
        if ((this.touchEvenHandler != null) && (!this.map_ready)) {
            this.touchEvenHandler.updatemap(this.sourceBitmap, 1);
        }
        this.map_ready = 1;
        this.ishuizhiMap = 1;
        this.post(new com.jlboat.phone.view.MapView$1(this));
        return;
    }

    private void updateMapBase64(com.boat.jrosbridge.message.nav_msgs.OccupancyGrid p9)
    {
        float v0_1 = p9.getInfo().getResolution();
        int v1_1 = p9.getInfo().getWidth();
        int v2_0 = p9.getInfo().getHeight();
        this.resolution = v0_1;
        this.bitmap_width = v1_1;
        this.bitmap_height = v2_0;
        this.leftBootmPoint = p9.getInfo().getOrigin().getPosition();
        this.origin_for_pixe_x = (0 - ((float) (this.leftBootmPoint.getX() / ((double) v0_1))));
        this.origin_for_pixe_y = (((float) this.bitmap_height) + ((float) (this.leftBootmPoint.getY() / ((double) v0_1))));
        byte[] v3_11 = android.util.Base64.decode(p9.getDataS(), 0);
        this.sourceBitmap = android.graphics.BitmapFactory.decodeByteArray(v3_11, 0, v3_11.length);
        if ((this.touchEvenHandler != null) && (!this.map_ready)) {
            this.touchEvenHandler.updatemap(this.sourceBitmap, 1);
        }
        this.map_ready = 1;
        this.ishuizhiMap = 1;
        this.post(new com.jlboat.phone.view.MapView$2(this));
        return;
    }

    private void updateVertexBuffer(com.boat.jrosbridge.message.sensor_msgs.LaserScan p28, int p29)
    {
        com.boat.ros.geometry.Vector3 v3_2 = org.ros.namespace.GraphName.of(p28.getHeader().getFrameId());
        com.boat.ros.geometry.Vector3 v4_9 = p28.getRanges();
        com.boat.ros.geometry.Vector3 v5_0 = p28.getRangeMin();
        float v6 = p28.getRangeMax();
        float v7 = p28.getAngleMin();
        float v8 = p28.getAngleIncrement();
        java.util.List v9_8 = 0;
        int v10 = 0;
        int v12 = 0;
        if (!this.hasPose) {
            double v15 = v4_9;
            double v25 = 0;
        } else {
            try {
                this.vectorScan.clear();
                Throwable v0_1 = 0;
            } catch (Throwable v0_0) {
                throw v0_0;
            }
            while (v0_1 < v4_9.length) {
                float v17;
                int v26;
                double v15_2;
                org.ros.namespace.GraphName v16;
                float v14_1 = v4_9[v0_1];
                if ((v5_0 >= v14_1) || (v14_1 >= v6)) {
                    v16 = v3_2;
                    v15_2 = v4_9;
                    v17 = v5_0;
                    v25 = v9_8;
                    v26 = v10;
                } else {
                    if (this.vectorScan.size() != 0) {
                        v16 = v3_2;
                    } else {
                        try {
                            v16 = v3_2;
                            try {
                                this.vectorScan.add(this.robotOrientation.rotateAndScaleVector(this.vector.subtract(this.vector)).add(this.robotPose));
                            } catch (Throwable v0_0) {
                                v17 = v5_0;
                                v26 = v10;
                            }
                        } catch (Throwable v0_0) {
                            v15 = v4_9;
                            v25 = v9_8;
                        }
                    }
                    com.boat.ros.geometry.Vector3 v3_7 = new com.boat.ros.geometry.Vector3;
                    v15_2 = v4_9;
                    v17 = v5_0;
                    v25 = v9_8;
                    v26 = v10;
                    v3_7((((double) ((float) (((double) v14_1) * Math.cos(((double) v7))))) + this.scan_offset_x), (((double) ((float) (((double) v14_1) * Math.sin(((double) v7))))) + this.scan_offset_y), 0);
                    this.vectorScan.add(this.robotOrientation.rotateAndScaleVector(v3_7.subtract(this.vector)).add(this.robotPose));
                }
                v7 += (((float) p29) * v8);
                v0_1 += p29;
                v4_9 = v15_2;
                v3_2 = v16;
                v5_0 = v17;
                v9_8 = v25;
                v10 = v26;
            }
            v15 = v4_9;
            v25 = v9_8;
        }
        this.scan_ready = 1;
        if (!this.ishuizhiMap) {
            this.post(new com.jlboat.phone.view.MapView$3(this));
        }
        return;
    }

    public void clearPoints()
    {
        android.util.Log.d("MapView", "\u6e05\u7a7a\u8def\u7ebf\u8f68\u8ff9");
        if (this.points != null) {
            this.points = new java.util.ArrayList();
        }
        return;
    }

    public double getDistFromP2L(double p11, double p13, double p15, double p17, double p19, double p21)
    {
        double v0 = (p21 - p17);
        double v2 = (p19 - p15);
        return (Math.abs((((p11 - p15) * v0) - ((p13 - p17) * v2))) / Math.sqrt(((v0 * v0) + (v2 * v2))));
    }

    public long getEnablePoint()
    {
        if (this.hasEnablePoint) {
            return this.enablePoint.getPointId();
        } else {
            return -1;
        }
    }

    public com.boat.support.slam.entity.floors.Lines getEnablePointLine()
    {
        if (this.hasEnablePoint) {
            com.boat.support.slam.entity.floors.Lines v0_1 = new com.boat.support.slam.entity.floors.Lines();
            v0_1.setX(this.enablePoint.getPositionX());
            v0_1.setY(this.enablePoint.getPositionY());
            return v0_1;
        } else {
            return 0;
        }
    }

    public com.boat.support.slam.entity.floors.Lines getRosMapPoint()
    {
        return this.getRosMapPoint((this.getWidth() / 2), (this.getHeight() / 2));
    }

    public com.boat.support.slam.entity.floors.Lines getRosMapPoint(int p6, int p7)
    {
        com.boat.support.slam.entity.floors.Lines v0_1 = new com.boat.support.slam.entity.floors.Lines();
        if (this.touchEvenHandler == null) {
            return 0;
        } else {
            android.graphics.PointF v1_0 = this.touchEvenHandler.coordinatesToImage(((float) p6), ((float) p7));
            if ((v1_0.x >= 0) && ((v1_0.y >= 0) && ((v1_0.x <= ((float) this.bitmap_width)) && (v1_0.y <= ((float) this.bitmap_height))))) {
                v0_1.setX(((double) ((v1_0.x - this.origin_for_pixe_x) * this.resolution)));
                v0_1.setY(((double) ((- (v1_0.y - this.origin_for_pixe_y)) * this.resolution)));
                return v0_1;
            } else {
                return 0;
            }
        }
    }

    public com.boat.support.slam.entity.floors.Lines getRosRobotPoint()
    {
        com.boat.support.slam.entity.floors.Lines v0 = 0;
        if (this.hasPose) {
            v0 = new com.boat.support.slam.entity.floors.Lines();
            v0.setX(this.rotatedP1.getX());
            v0.setY(this.rotatedP1.getY());
        }
        return v0;
    }

    public double hasPose(java.util.List p29, com.jlboat.phone.bean.PixeMarks$Pose p30, double p31)
    {
        double v14 = p30.getX();
        double v16 = p30.getY();
        int v12_1 = 0;
        while(true) {
            int v18 = 1;
            if (v12_1 >= (p29.size() - 1)) {
                return -4616189618054758400;
            } else {
                int v27 = v12_1;
                long v1_13 = this.pointToLine(v14, v16, ((com.jlboat.phone.bean.PixeMarks$Pose) p29.get(v12_1)).getX(), ((com.jlboat.phone.bean.PixeMarks$Pose) p29.get(v12_1)).getY(), ((com.jlboat.phone.bean.PixeMarks$Pose) p29.get((v12_1 + 1))).getX(), ((com.jlboat.phone.bean.PixeMarks$Pose) p29.get((v12_1 + 1))).getY());
                if (Math.abs(v1_13) >= p31) {
                    v18 = 0;
                }
                if (v18 != 0) {
                    break;
                }
                v12_1 = (v27 + 1);
            }
        }
        return Math.abs(v1_13);
    }

    boolean isInside(android.view.View p7, float p8, float p9)
    {
        if (p7 != null) {
            int[] v1_1 = new int[2];
            p7.getLocationOnScreen(v1_1);
            int v0_1 = v1_1[0];
            int v2_1 = v1_1[1];
            return new android.graphics.Rect(v0_1, v2_1, (p7.getWidth() + v0_1), (p7.getHeight() + v2_1)).contains(((int) p8), ((int) p9));
        } else {
            return 0;
        }
    }

    protected void onDraw(android.graphics.Canvas p28)
    {
        double v1_0 = this;
        com.jlboat.phone.view.MapView v2_0 = p28;
        if (this.map_ready) {
            if (this.touchEvenHandler != null) {
                if (this.currentStatus == 0) {
                    p28.drawBitmap(this.sourceBitmap, this.touchEvenHandler.getMatrix(), this.bitmapPaint);
                    this.currentStatus = -1;
                }
                p28.setDrawFilter(this.drawFilter);
                p28.drawBitmap(this.sourceBitmap, this.touchEvenHandler.getMatrix(), this.bitmapPaint);
                if (this.ishuizhiMap) {
                    this.ishuizhiMap = 0;
                }
            }
            if ((this.scan_ready) && ((this.vectorScan != null) && (this.vectorScan.size() > 0))) {
                try {
                    android.graphics.PointF v0_69 = new float[(this.vectorScan.size() * 2)];
                    this.scanFloats = v0_69;
                    this.scanPath = new android.graphics.Path();
                    android.graphics.PointF v0_20 = 0;
                } catch (android.graphics.PointF v0_21) {
                    throw v0_21;
                }
                while (v0_20 < this.scanFloats.length) {
                    double v7_55 = this.touchEvenHandler;
                    float v8_48 = this.origin_for_pixe_x;
                    float v9_110 = this.vectorScan.get((v0_20 / 2));
                    this.scanPointF = v7_55.coordinatesToCanvas((v8_48 + (((float) ((com.boat.ros.geometry.Vector3) this).getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) ((com.boat.ros.geometry.Vector3) this.vectorScan.get((v0_20 / 2))).getY()) / this.resolution)));
                    this.scanFloats[v0_20] = this.scanPointF.x;
                    this.scanFloats[(v0_20 + 1)] = this.scanPointF.y;
                    if (v0_20 != null) {
                        this.scanPath.lineTo(this.scanPointF.x, this.scanPointF.y);
                    } else {
                        this.scanPath.moveTo(this.scanPointF.x, this.scanPointF.y);
                    }
                    v0_20 += 2;
                }
                this.scanPath.close();
                p28.drawPath(this.scanPath, this.lowScanPaint);
                p28.drawPoints(v1_0.scanFloats, v1_0.scanPaint);
            }
            if (this.poseMutex != null) {
                try {
                    if ((this.touchEvenHandler != null) && (this.hasPose)) {
                        this.robotPath = new android.graphics.Path();
                        this.robotPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + ((float) (this.rotatedP1.getX() / ((double) this.resolution)))), (this.origin_for_pixe_y - ((float) (this.rotatedP1.getY() / ((double) this.resolution)))));
                        this.robotPath.moveTo(this.robotPointF.x, this.robotPointF.y);
                        this.robotLPF = new android.graphics.PointF(this.robotPointF.x, v1_0.robotPointF.y);
                        this.robotPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + ((float) (this.rotatedP2.getX() / ((double) this.resolution)))), (this.origin_for_pixe_y - ((float) (this.rotatedP2.getY() / ((double) this.resolution)))));
                        this.robotPath.lineTo(this.robotPointF.x, this.robotPointF.y);
                        this.robotPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + ((float) (this.rotatedP3.getX() / ((double) this.resolution)))), (this.origin_for_pixe_y - ((float) (this.rotatedP3.getY() / ((double) this.resolution)))));
                        this.robotPath.lineTo(this.robotPointF.x, this.robotPointF.y);
                        this.robotPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + ((float) (this.rotatedP4.getX() / ((double) this.resolution)))), (this.origin_for_pixe_y - ((float) (this.rotatedP4.getY() / ((double) this.resolution)))));
                        this.robotPath.lineTo(this.robotPointF.x, this.robotPointF.y);
                        this.robotPath.close();
                        p28.drawPath(this.robotPath, this.bitmapPaint);
                    }
                } catch (android.graphics.PointF v0_18) {
                    throw v0_18;
                }
            }
            this.hasEnablePoint = 0;
            if ((this.posintLists != null) && (this.posintLists.size() > 0)) {
                android.graphics.PointF v0_26 = this.posintLists.iterator();
                while (v0_26.hasNext()) {
                    float v8_39 = ((com.boat.support.slam.entity.floors.Points) v0_26.next());
                    this.posintPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) v8_39.getPositionX()) / this.resolution)), (this.origin_for_pixe_y - (((float) v8_39.getPositionY()) / this.resolution)));
                    if (!"\u5145\u7535\u6869".equals(v8_39.getPointName())) {
                        if (!"\u521d\u59cb\u70b9".equals(v8_39.getPointName())) {
                            if ((v8_39.getBindPointId() == 0) || ((v8_39.getBindMapId() == 0) || (v8_39.getBindFloorId() == 0))) {
                                this.pointPaint.setColor(this.getResources().getColor(2131034175));
                            } else {
                                this.pointPaint.setColor(this.getResources().getColor(2131034150));
                            }
                        } else {
                            this.pointPaint.setColor(this.getResources().getColor(2131034214));
                            v8_39.setPointName(this.getResources().getString(2131493071));
                        }
                    } else {
                        this.pointPaint.setColor(this.getResources().getColor(2131034205));
                        v8_39.setPointName(this.getResources().getString(2131493070));
                    }
                    p28.drawCircle(this.posintPointF.x, this.posintPointF.y, 1088421888, this.pointPaint);
                    String v10_61 = 1092616192;
                    if (this.isAutoPoint) {
                        if (!this.isScreenMode) {
                            if ((this.robotLPF != null) && ((Math.abs((this.posintPointF.x - this.robotLPF.x)) <= 1092616192) && (Math.abs((this.posintPointF.y - this.robotLPF.y)) <= 1092616192))) {
                                p28.drawCircle(this.posintPointF.x, v1_0.posintPointF.y, 1097859072, v1_0.pointPaintCheck);
                                this.enablePoint = v8_39;
                                this.enablePointF = new android.graphics.PointF(this.posintPointF.x, this.posintPointF.y);
                                this.hasEnablePoint = 1;
                            }
                        } else {
                            if ((Math.abs((this.posintPointF.x - ((float) (this.getWidth() / 2)))) <= 1092616192) && (Math.abs((this.posintPointF.y - ((float) (this.getHeight() / 2)))) <= 1092616192)) {
                                p28.drawCircle(this.posintPointF.x, v1_0.posintPointF.y, 1097859072, v1_0.pointPaintCheck);
                                this.enablePoint = v8_39;
                                this.enablePointF = new android.graphics.PointF(this.posintPointF.x, this.posintPointF.y);
                                this.hasEnablePoint = 1;
                            }
                        }
                    }
                    if ((!v8_39.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) || (!this.isShowId)) {
                        p28.drawText(v8_39.getPointName(), (this.posintPointF.x + v10_61), (this.posintPointF.y - v10_61), this.pointPaint);
                        if ((v8_39.getWaitPoints() != null) && (!v8_39.getWaitPoints().isEmpty())) {
                            String v3_44 = 0;
                            while (v3_44 < v8_39.getWaitPoints().size()) {
                                String v4_30 = this.touchEvenHandler;
                                float v9_90 = (this.origin_for_pixe_x + (((float) ((com.boat.support.slam.entity.floors.Position) v8_39.getWaitPoints().get(v3_44)).getX()) / this.resolution));
                                float v12_39 = this.origin_for_pixe_y;
                                android.graphics.Paint v13_53 = v8_39.getWaitPoints().get(v3_44);
                                this.posintWaitPointF = v4_30.coordinatesToCanvas(v9_90, (v12_39 - (((float) ((com.boat.support.slam.entity.floors.Position) this).getY()) / this.resolution)));
                                p28.drawCircle(this.posintWaitPointF.x, v1_0.posintWaitPointF.y, 1084227584, v1_0.pointWaitPaint);
                                p28.drawText(new StringBuilder().append(v8_39.getPointName()).append(this.getResources().getString(2131493111)).append((v3_44 + 1)).toString(), (this.posintWaitPointF.x + v10_61), (this.posintWaitPointF.y - v10_61), this.pointWaitPaint);
                                v3_44++;
                            }
                        }
                    } else {
                        p28.drawText(new StringBuilder().append(v8_39.getPointId()).append("").toString(), (this.posintPointF.x + v10_61), (this.posintPointF.y - v10_61), this.pointPaint);
                        if ((v8_39.getWaitPoints() != null) && (!v8_39.getWaitPoints().isEmpty())) {
                            float v9_108 = 0;
                            while (v9_108 < v8_39.getWaitPoints().size()) {
                                float v12_52 = this.touchEvenHandler;
                                android.graphics.Paint v13_63 = (this.origin_for_pixe_x + (((float) ((com.boat.support.slam.entity.floors.Position) v8_39.getWaitPoints().get(v9_108)).getX()) / this.resolution));
                                float v14_21 = this.origin_for_pixe_y;
                                float v15_4 = v8_39.getWaitPoints().get(v9_108);
                                this.posintWaitPointF = v12_52.coordinatesToCanvas(v13_63, (v14_21 - (((float) ((com.boat.support.slam.entity.floors.Position) this).getY()) / this.resolution)));
                                p28.drawCircle(this.posintWaitPointF.x, v1_0.posintWaitPointF.y, 1084227584, v1_0.pointWaitPaint);
                                p28.drawText(new StringBuilder().append(v8_39.getPointId()).append(this.getResources().getString(2131493111)).append((v9_108 + 1)).toString(), (this.posintWaitPointF.x + v10_61), (this.posintWaitPointF.y - v10_61), this.pointWaitPaint);
                                v9_108++;
                                String v4 = 0;
                            }
                        }
                    }
                    v4 = 0;
                }
            }
            if ((this.shapeAreas != null) && (this.shapeAreas.size() > 0)) {
                this.pixeMarksList.clear();
                android.graphics.PointF v0_10 = 0;
                String v3_15 = 0;
                String v4_24 = this.shapeAreas.iterator();
                while (v4_24.hasNext()) {
                    android.graphics.Paint v13_11;
                    float v8_29 = ((com.boat.support.slam.entity.floors.ShapeAreas) v4_24.next());
                    float v9_24 = new com.jlboat.phone.bean.PixeMarks();
                    v9_24.setId(v8_29.getShapeId());
                    String v10_40 = new java.util.LinkedList();
                    float v11_25 = new android.graphics.Path();
                    float v12_6 = new com.jlboat.phone.bean.PixeMarks$Pose();
                    android.graphics.Paint v13_9 = v8_29.getType();
                    switch (v13_9.hashCode()) {
                        case -1360216880:
                            if (!v13_9.equals("circle")) {
                                v13_11 = -1;
                            } else {
                                v13_11 = 1;
                            }
                            break;
                        case 102977279:
                            if (!v13_9.equals("lines")) {
                            } else {
                                v13_11 = 0;
                            }
                            break;
                        default:
                    }
                    float v20_2;
                    android.graphics.PointF v21_0;
                    switch (v13_11) {
                        case 0:
                            if ((v8_29.getLines() == null) || (v8_29.getLines().isEmpty())) {
                                v21_0 = v3_15;
                                v20_2 = v4_24;
                                v3_15 = v21_0;
                            } else {
                                float v5_25 = 0;
                                while (v5_25 < v8_29.getLines().size()) {
                                    android.graphics.Paint v6_33 = this.touchEvenHandler;
                                    double v7_46 = this.origin_for_pixe_x;
                                    android.graphics.Paint v13_38 = v8_29.getLines().get(v5_25);
                                    android.graphics.PointF v21_1 = v3_15;
                                    float v20_4 = v4_24;
                                    v0_10 = v6_33.coordinatesToCanvas((v7_46 + (((float) ((com.boat.support.slam.entity.floors.Lines) this).getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) ((com.boat.support.slam.entity.floors.Lines) v8_29.getLines().get(v5_25)).getY()) / this.resolution)));
                                    if (v0_10 != null) {
                                        if (v5_25 != 0) {
                                            v11_25.lineTo(v0_10.x, v0_10.y);
                                        } else {
                                            v11_25.moveTo(v0_10.x, v0_10.y);
                                        }
                                    }
                                    if (v0_10 != null) {
                                        v12_6.setX(((double) v0_10.x));
                                        v12_6.setY(((double) v0_10.y));
                                        v10_40.add(v12_6);
                                    }
                                    v5_25++;
                                    v4_24 = v20_4;
                                    v3_15 = v21_1;
                                }
                                v21_0 = v3_15;
                                v20_2 = v4_24;
                                if ((v8_29.getLines().size() > 2) && (v8_29.getClosed())) {
                                    v11_25.close();
                                    p28.drawPath(v11_25, this.markerFillPaint);
                                    v10_40.add(((com.jlboat.phone.bean.PixeMarks$Pose) v10_40.get(0)));
                                }
                                v9_24.setPoseList(v10_40);
                                this.pixeMarksList.add(v9_24);
                                if (this.delateShapeId != v8_29.getShapeId()) {
                                    p28.drawPath(v11_25, this.markerPaint);
                                } else {
                                    p28.drawPath(v11_25, this.markerDelPaint);
                                }
                                if ((!this.isEdit) || (v0_10 == null)) {
                                } else {
                                    p28.drawText(new StringBuilder().append(v8_29.getOrderNum()).append("").toString(), v0_10.x, v0_10.y, this.markerTextPaint);
                                }
                            }
                            break;
                        case 1:
                            if ((v8_29.getCircle() == null) || (v8_29.getCircle().getPosition() == null)) {
                                v21_0 = v3_15;
                                v20_2 = v4_24;
                            } else {
                                v3_15 = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) v8_29.getCircle().getPosition().getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) v8_29.getCircle().getPosition().getY()) / this.resolution)));
                                if (v3_15 != null) {
                                    p28.drawCircle(v3_15.x, v3_15.y, ((((float) v8_29.getCircle().getRadius()) / this.resolution) * ((float) this.touchEvenHandler.getZoomX())), this.circleFillPaint);
                                    if (this.delateShapeId != v8_29.getShapeId()) {
                                        p28.drawCircle(v3_15.x, v3_15.y, ((((float) v8_29.getCircle().getRadius()) / this.resolution) * ((float) this.touchEvenHandler.getZoomX())), this.circlePaint);
                                    } else {
                                        p28.drawCircle(v3_15.x, v3_15.y, ((((float) v8_29.getCircle().getRadius()) / this.resolution) * ((float) this.touchEvenHandler.getZoomX())), this.circleDelPaint);
                                    }
                                    if (this.isEdit) {
                                        p28.drawText(new StringBuilder().append(v8_29.getOrderNum()).append("").toString(), v3_15.x, v3_15.y, this.markerTextPaint);
                                    }
                                }
                                v20_2 = v4_24;
                            }
                            break;
                        default:
                            v21_0 = v3_15;
                            v20_2 = v4_24;
                    }
                    v4_24 = v20_2;
                    android.graphics.Paint v6 = 1084227584;
                }
            }
            if ((this.linesListStyle != null) && (this.linesListStyle.size() > 0)) {
                android.graphics.PointF v0_35 = new android.graphics.Path();
                String v4_15 = 0;
                while (v4_15 < this.linesListStyle.size()) {
                    String v3_14 = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) ((com.boat.support.slam.entity.floors.Lines) this.linesListStyle.get(v4_15)).getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) ((com.boat.support.slam.entity.floors.Lines) this.linesListStyle.get(v4_15)).getY()) / this.resolution)));
                    if (v3_14 != null) {
                        if (v4_15 != null) {
                            v0_35.lineTo(v3_14.x, v3_14.y);
                        } else {
                            v0_35.moveTo(v3_14.x, v3_14.y);
                        }
                    }
                    v4_15++;
                }
                if (!this.isScreenMode) {
                    if (!this.hasEnablePoint) {
                        if (this.hasPose) {
                            this.robotPointF = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) this.rotatedP1.getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) this.rotatedP1.getY()) / this.resolution)));
                            v0_35.lineTo(this.robotPointF.x, this.robotPointF.y);
                        }
                    } else {
                        v0_35.lineTo(this.enablePointF.x, this.enablePointF.y);
                    }
                } else {
                    if (!this.hasEnablePoint) {
                        v0_35.lineTo(((float) (this.getWidth() / 2)), ((float) (this.getHeight() / 2)));
                        if (this.isClose) {
                            v0_35.close();
                        }
                    } else {
                        v0_35.lineTo(this.enablePointF.x, this.enablePointF.y);
                    }
                }
                p28.drawPath(v0_35, this.linesStylePaint);
            }
            if ((this.regionList != null) && (this.regionList.size() > 0)) {
                android.graphics.PointF v0_6 = 0;
                String v3_4 = 0;
                String v4_11 = this.regionList.iterator();
                while (v4_11.hasNext()) {
                    float v20_0;
                    long v16_0;
                    float v5_4 = ((com.boat.support.slam.entity.floors.Region) v4_11.next());
                    android.graphics.Paint v6_12 = new com.jlboat.phone.bean.PixeMarks();
                    v6_12.setId(v5_4.getRegionId());
                    double v7_14 = new java.util.LinkedList();
                    float v8_15 = new android.graphics.Path();
                    float v9_15 = new com.jlboat.phone.bean.PixeMarks$Pose();
                    if ((v5_4.getPoints() == null) || (v5_4.getPoints().isEmpty())) {
                        v16_0 = v3_4;
                        v20_0 = v4_11;
                    } else {
                        String v10_16 = 0;
                        while (v10_16 < v5_4.getPoints().size()) {
                            float v11_23 = this.touchEvenHandler;
                            float v12_3 = this.origin_for_pixe_x;
                            android.graphics.Paint v13_2 = v5_4.getPoints().get(v10_16);
                            long v16_1 = v3_4;
                            float v20_1 = v4_11;
                            v0_6 = v11_23.coordinatesToCanvas((v12_3 + (((float) ((com.boat.support.slam.entity.floors.Lines) this).getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) ((com.boat.support.slam.entity.floors.Lines) v5_4.getPoints().get(v10_16)).getY()) / this.resolution)));
                            if (v0_6 != null) {
                                if (v10_16 != null) {
                                    v8_15.lineTo(v0_6.x, v0_6.y);
                                } else {
                                    v8_15.moveTo(v0_6.x, v0_6.y);
                                }
                            }
                            if (v0_6 != null) {
                                v9_15.setX(((double) v0_6.x));
                                v9_15.setY(((double) v0_6.y));
                                v7_14.add(v9_15);
                            }
                            v10_16++;
                            v3_4 = v16_1;
                            v4_11 = v20_1;
                        }
                        v16_0 = v3_4;
                        v20_0 = v4_11;
                        if (v5_4.getPoints().size() > 2) {
                            v8_15.close();
                            v7_14.add(((com.jlboat.phone.bean.PixeMarks$Pose) v7_14.get(0)));
                        }
                        v6_12.setPoseList(v7_14);
                        p28.drawPath(v8_15, this.regionFillPaint);
                        if (this.selectRegionId != v5_4.getRegionId()) {
                            p28.drawPath(v8_15, this.regionPaint);
                        } else {
                            p28.drawPath(v8_15, this.markerDelPaint);
                        }
                        if (v0_6 != null) {
                            String v4_10 = this.getResources().getString(2131493139);
                            if (v5_4.getType() == 1) {
                                v4_10 = this.getResources().getString(2131493034);
                            }
                            if (v5_4.getType() == 2) {
                                v4_10 = this.getResources().getString(2131493086);
                            }
                            if (v5_4.getType() == 3) {
                                v4_10 = this.getResources().getString(2131493184);
                            }
                            if (v5_4.getType() == 4) {
                                v4_10 = this.getResources().getString(2131492907);
                            }
                            if (v5_4.getType() == 5) {
                                v4_10 = this.getResources().getString(2131493041);
                            }
                            if (v5_4.getType() == 6) {
                                v4_10 = this.getResources().getString(2131492909);
                            }
                            p28.drawText(new StringBuilder().append(this.getResources().getString(2131493140)).append(v5_4.getOrderNum()).append(": ").append(v4_10).toString(), v0_6.x, v0_6.y, this.regionTextPaint);
                        }
                    }
                    v3_4 = v16_0;
                    v4_11 = v20_0;
                }
            }
            if ((this.cleanAreas != null) && (this.cleanAreas.size() > 0)) {
                android.graphics.PointF v0_3 = 0;
                String v3_58 = this.cleanAreas.iterator();
                while (v3_58.hasNext()) {
                    String v4_2 = ((com.boat.support.slam.entity.floors.CleanArea) v3_58.next());
                    float v5_1 = new android.graphics.Path();
                    if ((v4_2.getLines() != null) && (!v4_2.getLines().isEmpty())) {
                        android.graphics.Paint v6_4 = 0;
                        while (v6_4 < v4_2.getLines().size()) {
                            double v7_9 = this.touchEvenHandler;
                            float v8_8 = this.origin_for_pixe_x;
                            float v9_7 = v4_2.getLines().get(v6_4);
                            float v8_9 = (v8_8 + (((float) ((com.boat.support.slam.entity.floors.Lines) this).getX()) / this.resolution));
                            float v9_12 = this.origin_for_pixe_y;
                            String v10_6 = v4_2.getLines().get(v6_4);
                            v0_3 = v7_9.coordinatesToCanvas(v8_9, (v9_12 - (((float) ((com.boat.support.slam.entity.floors.Lines) this).getY()) / this.resolution)));
                            if (v0_3 != null) {
                                if (v6_4 != null) {
                                    v5_1.lineTo(v0_3.x, v0_3.y);
                                } else {
                                    v5_1.moveTo(v0_3.x, v0_3.y);
                                }
                            }
                            v6_4++;
                        }
                        v5_1.close();
                        p28.drawPath(v5_1, this.cleanAreasPaint);
                        if (v0_3 != null) {
                            p28.drawText(new StringBuilder().append(v4_2.getCleanAreaName()).append("").toString(), v0_3.x, v0_3.y, this.bitmapPaint);
                        }
                    }
                }
            }
            if ((this.cleanPathReady) && ((this.cleanPathpoints != null) && (this.cleanPathpoints.size() > 1))) {
                android.graphics.PointF v0_51 = new android.graphics.Path();
                String v4_0 = 1;
                float v5_45 = this.cleanPathpoints.iterator();
                while (v5_45.hasNext()) {
                    android.graphics.Paint v6_0 = ((com.boat.jrosbridge.message.geometry_msgs.Point) v5_45.next());
                    String v3_0 = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) v6_0.getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) v6_0.getY()) / this.resolution)));
                    if (v4_0 == null) {
                        v0_51.lineTo(v3_0.x, v3_0.y);
                    } else {
                        v0_51.moveTo(v3_0.x, v3_0.y);
                        v4_0 = 0;
                    }
                }
                p28.drawPath(v0_51, this.cleanPathPaint);
            }
            if ((this.path_ready) && ((this.points != null) && ((!this.points.isEmpty()) && (this.points.size() > 2)))) {
                String v3_62 = this.points.iterator();
                while (v3_62.hasNext()) {
                    String v4_87 = ((com.boat.jrosbridge.message.geometry_msgs.Point) v3_62.next());
                    android.graphics.PointF v0_94 = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) v4_87.getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) v4_87.getY()) / this.resolution)));
                    p28.drawCircle(v0_94.x, v0_94.y, 1084227584, this.pathPaint);
                }
            }
            if ((this.mGlobalPlans == null) || (this.mGlobalPlans.size() <= 0)) {
                String v4_70 = p28;
                com.jlboat.phone.view.MapView v2_1 = this;
            } else {
                android.graphics.Paint v6_46 = (1067030938 / this.resolution);
                double v7_67 = 0;
                while (v7_67 < v1_0.mGlobalPlans.size()) {
                    float v8_67 = ((com.boat.support.slam.entity.floors.GlobalPlans) v1_0.mGlobalPlans.get(v7_67));
                    float v9_156 = v8_67.getDir();
                    String v10_95 = v8_67.getLines();
                    float v11_83 = new android.graphics.Path();
                    float v12_92 = 0;
                    while (v12_92 < v10_95.size()) {
                        double v1_19;
                        float v20_16;
                        android.graphics.PointF v21_2;
                        float v15_15;
                        android.graphics.Paint v13_71 = ((com.boat.support.slam.entity.floors.Lines) v10_95.get(v12_92));
                        String v3_88 = v1_0.touchEvenHandler.coordinatesToCanvas((v1_0.origin_for_pixe_x + (((float) v13_71.getX()) / v1_0.resolution)), (v1_0.origin_for_pixe_y - (((float) v13_71.getY()) / v1_0.resolution)));
                        if (v3_88 == null) {
                            v15_15 = v7_67;
                            v20_16 = v8_67;
                            v21_2 = v9_156;
                            v1_19 = v10_95;
                        } else {
                            if (v12_92 != 0) {
                                v15_15 = v7_67;
                                v20_16 = v8_67;
                                v21_2 = v9_156;
                                v11_83.lineTo(v3_88.x, v3_88.y);
                                if (v12_92 != (v10_95.size() - 1)) {
                                    v1_19 = v10_95;
                                } else {
                                    double v1_25 = ((com.boat.support.slam.entity.floors.Lines) v10_95.get((v12_92 - 1)));
                                    android.graphics.PointF v0_83 = this.touchEvenHandler.coordinatesToCanvas((this.origin_for_pixe_x + (((float) v1_25.getX()) / this.resolution)), (this.origin_for_pixe_y - (((float) v1_25.getY()) / this.resolution)));
                                    double v7_84 = Math.atan2(((double) (v3_88.y - v0_83.y)), ((double) (v3_88.x - v0_83.x)));
                                    float v5_57 = v3_88;
                                    v1_19 = v10_95;
                                    float v9_167 = ((float) (((double) v5_57.x) - (((double) v6_46) * Math.cos((v7_84 + 4602891378046628709)))));
                                    String v3_93 = ((float) (((double) v5_57.y) - (((double) v6_46) * Math.sin((v7_84 + 4602891378046628709)))));
                                    v11_83.moveTo(((float) (((double) v3_88.x) - (((double) v6_46) * Math.cos((v7_84 - 4602891378046628709))))), ((float) (((double) v5_57.y) - (((double) v6_46) * Math.sin((v7_84 - 4602891378046628709))))));
                                    v11_83.lineTo(v5_57.x, v5_57.y);
                                    v11_83.lineTo(v9_167, v3_93);
                                }
                            } else {
                                if (v9_156 != 0) {
                                    v15_15 = v7_67;
                                    v20_16 = v8_67;
                                    v21_2 = v9_156;
                                    v11_83.moveTo(v3_88.x, v3_88.y);
                                    v1_19 = v10_95;
                                } else {
                                    String v4_83 = ((com.boat.support.slam.entity.floors.Lines) v10_95.get((v12_92 + 1)));
                                    v15_15 = v7_67;
                                    v20_16 = v8_67;
                                    v21_2 = v9_156;
                                    android.graphics.PointF v0_88 = v1_0.touchEvenHandler.coordinatesToCanvas((v1_0.origin_for_pixe_x + (((float) v4_83.getX()) / v1_0.resolution)), (v1_0.origin_for_pixe_y - (((float) v4_83.getY()) / v1_0.resolution)));
                                    String v4_85 = Math.atan2(((double) (v3_88.y - v0_88.y)), ((double) (v3_88.x - v0_88.x)));
                                    float v9_173 = v0_88;
                                    android.graphics.PointF v0_92 = ((float) (((double) v3_88.x) - (((double) v6_46) * Math.cos((v4_85 + 4602891378046628709)))));
                                    double v1_31 = ((float) (((double) v3_88.y) - (((double) v6_46) * Math.sin((v4_85 + 4602891378046628709)))));
                                    v11_83.moveTo(((float) (((double) v3_88.x) - (((double) v6_46) * Math.cos((v4_85 - 4602891378046628709))))), ((float) (((double) v3_88.y) - (((double) v6_46) * Math.sin((v4_85 - 4602891378046628709))))));
                                    v11_83.lineTo(v3_88.x, v3_88.y);
                                    v11_83.lineTo(v0_92, v1_31);
                                    v11_83.moveTo(v3_88.x, v3_88.y);
                                    android.graphics.PointF v0 = v9_173;
                                    v1_19 = v10_95;
                                }
                            }
                        }
                        v12_92++;
                        com.jlboat.phone.view.MapView v2 = p28;
                        v10_95 = v1_19;
                        v7_67 = v15_15;
                        v8_67 = v20_16;
                        v9_156 = v21_2;
                        v1_0 = this;
                    }
                    String v4_74;
                    float v15_12 = v7_67;
                    double v1 = v10_95;
                    if (this.selectedGpId != v8_67.getGlobalplanId()) {
                        v4_74 = p28;
                        p28.drawPath(v11_83, this.globalPlansPaint);
                    } else {
                        v4_74 = p28;
                        p28.drawPath(v11_83, this.selectedGlobalPlansPaint);
                    }
                    v11_83.close();
                    v7_67 = (v15_12 + 1);
                    v1_0 = this;
                    v2_0 = v4_74;
                }
                v4_70 = v2_0;
                v2_1 = v1_0;
            }
            if ((v2_1.ngNlineList == null) || (v2_1.ngNlineList.size() <= 0)) {
                v2 = v4_70;
            } else {
                v1 = 0;
                String v3_64 = 0;
                float v5_48 = (1067030938 / v2_1.resolution);
                android.graphics.Paint v6_49 = v2_1.ngNlineList.iterator();
                while (v6_49.hasNext()) {
                    String v4_72;
                    float v14_23;
                    double v19;
                    double v7_70 = ((com.jlboat.phone.bean.NgNline) v6_49.next());
                    float v8_63 = new android.graphics.Path();
                    String v3_65 = (v3_64 + 1);
                    android.graphics.PointF v0_70 = v2_1.touchEvenHandler.coordinatesToCanvas((v2_1.origin_for_pixe_x + (((float) v7_70.getStartX()) / v2_1.resolution)), (v2_1.origin_for_pixe_y - (((float) v7_70.getStartY()) / v2_1.resolution)));
                    v8_63.moveTo(v0_70.x, v0_70.y);
                    double v1_1 = v2_1.touchEvenHandler.coordinatesToCanvas((v2_1.origin_for_pixe_x + (((float) v7_70.getEndX()) / v2_1.resolution)), (v2_1.origin_for_pixe_y - (((float) v7_70.getEndY()) / v2_1.resolution)));
                    v8_63.lineTo(v1_1.x, v1_1.y);
                    switch (v7_70.getnLine().getDirection()) {
                        case 0:
                            v14_23 = v3_65;
                            v4_72 = v6_49;
                            v19 = v7_70;
                            double v7_74 = v1_1;
                            double v1_14 = Math.atan2(((double) (v0_70.y - v7_74.y)), ((double) (v0_70.x - v7_74.x)));
                            float v9_154 = ((float) (((double) v0_70.x) - (((double) v5_48) * Math.cos((v1_14 + 4602891378046628709)))));
                            String v10_94 = ((float) (((double) v0_70.y) - (((double) v5_48) * Math.sin((v1_14 + 4602891378046628709)))));
                            v8_63.moveTo(((float) (((double) v0_70.x) - (((double) v5_48) * Math.cos((v1_14 - 4602891378046628709))))), ((float) (((double) v0_70.y) - (((double) v5_48) * Math.sin((v1_14 - 4602891378046628709))))));
                            v8_63.lineTo(v0_70.x, v0_70.y);
                            v8_63.lineTo(v9_154, v10_94);
                            break;
                        case 1:
                            v14_23 = v3_65;
                            v4_72 = v6_49;
                            v19 = v7_70;
                            v7_74 = v1_1;
                            double v1_10 = Math.atan2(((double) (v7_74.y - v0_70.y)), ((double) (v7_74.x - v0_70.x)));
                            float v9_145 = ((float) (((double) v7_74.x) - (((double) v5_48) * Math.cos((v1_10 + 4602891378046628709)))));
                            String v10_90 = ((float) (((double) v7_74.y) - (((double) v5_48) * Math.sin((v1_10 + 4602891378046628709)))));
                            v8_63.moveTo(((float) (((double) v7_74.x) - (((double) v5_48) * Math.cos((v1_10 - 4602891378046628709))))), ((float) (((double) v7_74.y) - (((double) v5_48) * Math.sin((v1_10 - 4602891378046628709))))));
                            v8_63.lineTo(v7_74.x, v7_74.y);
                            v8_63.lineTo(v9_145, v10_90);
                            break;
                        case 2:
                            float v9_132 = Math.atan2(((double) (v0_70.y - v1_1.y)), ((double) (v0_70.x - v1_1.x)));
                            v14_23 = v3_65;
                            v4_72 = v6_49;
                            v19 = v7_70;
                            android.graphics.Paint v6_52 = ((float) (((double) v0_70.x) - (((double) v5_48) * Math.cos((v9_132 + 4602891378046628709)))));
                            v7_74 = v1_1;
                            double v1_4 = ((float) (((double) v0_70.y) - (((double) v5_48) * Math.sin((v9_132 + 4602891378046628709)))));
                            v8_63.moveTo(((float) (((double) v0_70.x) - (((double) v5_48) * Math.cos((v9_132 - 4602891378046628709))))), ((float) (((double) v0_70.y) - (((double) v5_48) * Math.sin((v9_132 - 4602891378046628709))))));
                            v8_63.lineTo(v0_70.x, v0_70.y);
                            v8_63.lineTo(v6_52, v1_4);
                            double v1_6 = Math.atan2(((double) (v7_74.y - v0_70.y)), ((double) (v7_74.x - v0_70.x)));
                            android.graphics.Paint v6_53 = ((float) (((double) v7_74.x) - (((double) v5_48) * Math.cos((v1_6 + 4602891378046628709)))));
                            String v10_86 = ((float) (((double) v7_74.y) - (((double) v5_48) * Math.sin((v1_6 + 4602891378046628709)))));
                            v8_63.moveTo(((float) (((double) v7_74.x) - (((double) v5_48) * Math.cos((v1_6 - 4602891378046628709))))), ((float) (((double) v7_74.y) - (((double) v5_48) * Math.sin((v1_6 - 4602891378046628709))))));
                            v8_63.lineTo(v7_74.x, v7_74.y);
                            v8_63.lineTo(v6_53, v10_86);
                            break;
                        default:
                            v14_23 = v3_65;
                            v4_72 = v6_49;
                            v19 = v7_70;
                    }
                    com.jlboat.phone.view.MapView v2_9;
                    if (v19.getnLine().getId() != this.ngNlineID) {
                        v2_9 = p28;
                        p28.drawPath(v8_63, this.ngLinePaint);
                    } else {
                        v2_9 = p28;
                        p28.drawPath(v8_63, this.ngLineSelectPaint);
                    }
                    v3_64 = v14_23;
                    v4_70 = v2_9;
                    v2_1 = this;
                    v6_49 = v4_72;
                }
                v2 = v4_70;
            }
            return;
        } else {
            return;
        }
    }

    protected void onLayout(boolean p4, int p5, int p6, int p7, int p8)
    {
        this = super.onLayout(p4, p5, p6, p7, p8);
        if ((p4) && (this.sourceBitmap != null)) {
            this.touchEvenHandler = new com.jlboat.phone.view.TouchEvenHandler(this, this.sourceBitmap, 0);
        }
        return;
    }

    public void onStart(com.boat.base.BaseApplication p8)
    {
        this.mApp = p8;
        if (this.sourceBitmap != null) {
            if (this.sourceBitmap.isRecycled()) {
                this.sourceBitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap$Config.RGB_565);
            }
        } else {
            this.sourceBitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap$Config.RGB_565);
        }
        android.util.Log.d("MapView", new StringBuilder().append("onStart: version_code ").append(com.jlboat.phone.application.BoatSlamApplication.classis_version_code).toString());
        if (com.jlboat.phone.application.BoatSlamApplication.classis_version_code <= 427) {
            this.mapSubscriber = new com.boat.jrosbridge.Topic("/map", com.boat.jrosbridge.message.nav_msgs.OccupancyGrid, com.jlboat.phone.application.BoatSlamApplication.client);
            this.mapSubscriber.setCompression("png");
            this.mapSubscriber.subscribe(new com.jlboat.phone.view.MapView$19(this));
        } else {
            android.util.Log.d("MapView", "onStart: ");
            this.publisherTimer = new java.util.Timer();
            this.publisherTimer.schedule(new com.jlboat.phone.view.MapView$18(this), 0, 100);
        }
        if (!this.isRobot) {
            this.scanPoseSub = new com.boat.jrosbridge.Topic("/scan_pose", com.boat.jrosbridge.message.geometry_msgs.Pose, com.jlboat.phone.application.BoatSlamApplication.client);
            this.scanPoseSub.subscribe(new com.jlboat.phone.view.MapView$20(this));
            this.subscriber = new com.boat.jrosbridge.Topic("/scan", com.boat.jrosbridge.message.sensor_msgs.LaserScan, com.jlboat.phone.application.BoatSlamApplication.client);
            this.subscriber.subscribe(new com.jlboat.phone.view.MapView$21(this));
        }
        this.tracked_pose_scriber = new com.boat.jrosbridge.Topic("tracked_pose", com.boat.jrosbridge.message.geometry_msgs.PoseStamped, com.jlboat.phone.application.BoatSlamApplication.client);
        this.tracked_pose_scriber.subscribe(new com.jlboat.phone.view.MapView$22(this));
        this.pathlayer = new com.boat.jrosbridge.Topic("visualization_marker", com.boat.jrosbridge.message.visualization_msgs.Marker, com.jlboat.phone.application.BoatSlamApplication.client);
        this.pathlayer.subscribe(new com.jlboat.phone.view.MapView$23(this));
        if (this.useCleanPath) {
            this.cleanPathSubscriber = new com.boat.jrosbridge.Topic("/move_base/execute_path", com.boat.jrosbridge.message.nav_msgs.Path, com.jlboat.phone.application.BoatSlamApplication.client);
            this.cleanPathSubscriber.subscribe(new com.jlboat.phone.view.MapView$24(this));
        }
        return;
    }

    public void onStop()
    {
        if ((com.jlboat.phone.application.BoatSlamApplication.classis_version_code > 427) && (this.publisherTimer != null)) {
            this.publisherTimer.cancel();
            this.publisherTimer.purge();
            this.publisherTimer = 0;
        }
        this.map_ready = 0;
        if (this.mapSubscriber != null) {
            this.mapSubscriber.unsubscribe();
        }
        if (this.scanPoseSub != null) {
            this.scanPoseSub.unsubscribe();
        }
        if (this.subscriber != null) {
            this.subscriber.unsubscribe();
        }
        if (this.pathlayer != null) {
            this.pathlayer.unsubscribe();
        }
        if (this.cleanPathSubscriber != null) {
            this.cleanPathSubscriber.unsubscribe();
        }
        if (this.sourceBitmap != null) {
            this.sourceBitmap.recycle();
        }
        return;
    }

    public boolean onTouchEvent(android.view.MotionEvent p9)
    {
        if (this.sourceBitmap != null) {
            float v0_1 = p9.getX();
            float v2 = p9.getY();
            if (p9.getAction() == 0) {
                this.clickTime = System.currentTimeMillis();
                this.isUpOut = 0;
                this.hasResponseLongClickEvent = 0;
            }
            if (p9.getAction() == 2) {
                if (this.moveCallBackLines != null) {
                    this.moveCallBackLines.onMoveChange(this.getRosMapPoint());
                }
                if (!this.isInside(this, v0_1, v2)) {
                    this.isUpOut = 1;
                } else {
                    this.isUpOut = 0;
                }
                if (((System.currentTimeMillis() - this.clickTime) > 800) && ((!this.hasResponseLongClickEvent) && (!this.isUpOut))) {
                    this.hasResponseLongClickEvent = 1;
                }
            }
            p9.getAction();
            this.touchEvenHandler.touchEvent(p9);
            return 1;
        } else {
            return 1;
        }
    }

    public void setBuildType(boolean p1)
    {
        this.isbuild = p1;
        return;
    }

    public void setCleanAreas(java.util.List p2)
    {
        this.cleanAreas.clear();
        this.cleanAreas.addAll(p2);
        this.post(new com.jlboat.phone.view.MapView$13(this));
        return;
    }

    public void setDIYLineMode(boolean p2)
    {
        this.isScreenMode = p2;
        this.post(new com.jlboat.phone.view.MapView$17(this));
        return;
    }

    public void setDiYPAutoMode(boolean p1)
    {
        this.isAutoPoint = p1;
        return;
    }

    public void setEdit(boolean p1)
    {
        this.isEdit = p1;
        return;
    }

    public void setGlobalPlans(java.util.List p2)
    {
        this.mGlobalPlans.clear();
        this.mGlobalPlans.addAll(p2);
        this.post(new com.jlboat.phone.view.MapView$7(this));
        return;
    }

    public void setLinesStyle(java.util.List p2)
    {
        this.linesListStyle = p2;
        this.post(new com.jlboat.phone.view.MapView$9(this));
        return;
    }

    public void setLinesStyle(java.util.List p2, boolean p3)
    {
        this.linesListStyle = p2;
        this.isClose = p3;
        this.post(new com.jlboat.phone.view.MapView$10(this));
        return;
    }

    public void setMoveCallBackLines(com.jlboat.phone.view.MapView$MoveCallBackLines p1)
    {
        this.moveCallBackLines = p1;
        return;
    }

    public void setNavigationPathCallBack(com.jlboat.phone.view.MapView$PathCallBack p1)
    {
        this.navigationPathListen = p1;
        return;
    }

    public void setNgLineSelectId(long p2)
    {
        this.ngNlineID = p2;
        this.post(new com.jlboat.phone.view.MapView$15(this));
        return;
    }

    public void setNgLines(java.util.List p3)
    {
        this.ngNlineList = p3;
        android.util.Log.d("MapView", new StringBuilder().append("setNgLines: ngNlineList ").append(p3.size()).toString());
        this.post(new com.jlboat.phone.view.MapView$14(this));
        return;
    }

    public void setPoints(java.util.List p2)
    {
        this.posintLists.clear();
        this.posintLists.addAll(p2);
        this.post(new com.jlboat.phone.view.MapView$4(this));
        return;
    }

    public void setProhibition(java.util.List p2)
    {
        this.shapeAreas.clear();
        this.shapeAreas.addAll(p2);
        this.post(new com.jlboat.phone.view.MapView$5(this));
        return;
    }

    public void setRegion(java.util.List p2)
    {
        this.regionList.clear();
        this.regionList.addAll(p2);
        this.post(new com.jlboat.phone.view.MapView$6(this));
        return;
    }

    public void setRobot(boolean p1)
    {
        this.isRobot = p1;
        return;
    }

    public void setSelectedGlobalPlans(long p2)
    {
        this.selectedGpId = p2;
        this.post(new com.jlboat.phone.view.MapView$8(this));
        return;
    }

    public void setShowDiYP(boolean p2)
    {
        this.isShowId = p2;
        this.post(new com.jlboat.phone.view.MapView$16(this));
        return;
    }

    public void setTagRegionId(long p2)
    {
        this.selectRegionId = p2;
        this.post(new com.jlboat.phone.view.MapView$12(this));
        return;
    }

    public void setTagShapeId(long p2)
    {
        this.delateShapeId = p2;
        this.post(new com.jlboat.phone.view.MapView$11(this));
        return;
    }

    public void setUseCleanPath(boolean p1)
    {
        this.useCleanPath = p1;
        return;
    }
}
