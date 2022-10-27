using UnityEngine;

public class MyVRController : MonoBehaviour {
    public SteamVR_TrackedObject tracker;
    public SteamVR_TrackedController controller;    // 手柄控制器
    private Transform pickedObject = null;          // 待拾取的物体
    public LineRenderer line;                       // 射线Prefab

	// Use this for initialization
	void Start () {
        tracker = this.GetComponent<SteamVR_TrackedObject>();
        controller = this.GetComponent<SteamVR_TrackedController>();
        controller.TriggerClicked += OnTriggerClicked;     // 手柄按键按钮委托回调
        controller.TriggerUnclicked += OnTriggerUnclicked; // 手柄按键松开按钮委托回调
    }

	void Update () {
        if ( controller.triggerPressed )
        {
            line.enabled = true;  // 显示射线
            RaycastHit hitinfo;
            line.SetPosition(0, this.transform.position);  // 设置射线的起始位置
            // 根据Raycast设置射线的结束位置
            bool b = Physics.Raycast(transform.position, transform.forward, out hitinfo, 100);
            if (b)
                line.SetPosition(1, hitinfo.point);
            else
                line.SetPosition(1, this.transform.position + this.transform.forward * 10);
        }
        else
            line.enabled = false;   // 关闭射线
    }

    public void OnTriggerClicked(object sender, ClickedEventArgs e)
    {
        if (pickedObject != null) // 如果已经拾取了目标物体
            return;

        RaycastHit hitinfo;
        bool b = Physics.Raycast(this.transform.position, this.transform.forward, out hitinfo, 100, LayerMask.GetMask("Item"));
        if (b)  // 通过Raycast判断是否射中目标物体
        {
            pickedObject = hitinfo.transform;  // 获取被拾取的物体
            Rigidbody rigd = hitinfo.transform.GetComponent<Rigidbody>();
            rigd.useGravity = false;  // 取消目标物体的重力
            FixedJoint fj = hitinfo.transform.gameObject.AddComponent<FixedJoint>();
            fj.connectedBody = this.GetComponent<Rigidbody>();  // 使用FixedJoint将目标物体和手柄固定在一起
        }
    }

    public void OnTriggerUnclicked(object sender, ClickedEventArgs e)
    {
        if (pickedObject == null)  // 如果没有拾取目标物体
            return;

        FixedJoint fj = pickedObject.GetComponent<FixedJoint>();
        fj.connectedBody = null;
        Destroy(fj);  // 断开目标物体与手柄的连接状态
        Rigidbody rigid = pickedObject.GetComponent<Rigidbody>();
        rigid.useGravity = true;  // 恢复目标物体的重力

        var device = SteamVR_Controller.Input((int)tracker.index);
        rigid.velocity =  device.velocity * 3;  // 获得当前设备的移动方向
        rigid.angularVelocity = device.angularVelocity;  // 为目标物体加一个力，使其被投掷出去
        pickedObject = null;  // 清空拾取的目标物体
    }
}
