using UnityEngine;
using UnityEngine.EventSystems;  // 事件系统

// 继承拖拽事件接口
public class DragImage : MonoBehaviour, IDragHandler, IEndDragHandler
{
    public System.Action<PointerEventData> onDragEvent;
    public System.Action<PointerEventData> onDragEndEvent;
    // 开始拖拽
    public void OnDrag(PointerEventData eventData)
    {
        if (onDragEvent != null)
            onDragEvent(eventData);  // 响应开始拖拽
    }

    // 结束拖拽
    public void OnEndDrag(PointerEventData eventData)
    {
        if (onDragEndEvent != null)
            onDragEndEvent(eventData);   // 响应结束拖拽
    }
}
