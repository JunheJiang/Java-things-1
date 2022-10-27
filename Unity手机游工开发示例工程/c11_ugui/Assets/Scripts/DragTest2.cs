
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;
public class DragTest2 : MonoBehaviour {

    public RectTransform dragArea;
    public DragImage imageDrag;
    public Image imageTarget;
    
    void Start () {

        imageDrag.onDragEvent += (PointerEventData eventData) =>
          {
              Vector2 touchpos = ((PointerEventData)eventData).position; //获得当前拖动的屏幕坐标位置
              Vector2 uguiPos;
              bool isRect = RectTransformUtility.ScreenPointToLocalPointInRectangle(
                  dragArea, touchpos, eventData.enterEventCamera, out uguiPos); // 将屏幕坐标转换为ugui本地坐标
              Debug.Log(isRect);
              if (isRect && RectTransformUtility.RectangleContainsScreenPoint(dragArea, touchpos, ((PointerEventData)eventData).enterEventCamera))  // 如果拖动位置在区域内
                  imageDrag.GetComponent<RectTransform>().localPosition = uguiPos;  // 更新被拖动图像的位置
              imageDrag.GetComponent<Image>().raycastTarget = false;  // 拖动的时候，防止阻挡射线探测
          };

        imageDrag.onDragEndEvent += (PointerEventData eventData) =>
        {
            var go = ((PointerEventData)eventData).pointerEnter;
            if (go != null && go.name.CompareTo("Image Target") == 0)  // 如果拖动到目标位置
            {
                imageDrag.GetComponent<RectTransform>().position = imageTarget.rectTransform.position;
            }
            imageDrag.GetComponent<Image>().raycastTarget = true;
        };
    }
}
