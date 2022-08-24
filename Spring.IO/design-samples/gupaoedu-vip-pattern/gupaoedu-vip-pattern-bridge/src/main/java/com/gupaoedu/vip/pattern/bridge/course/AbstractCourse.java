package com.gupaoedu.vip.pattern.bridge.course;

/**
 * Created by Tom.
 * 抽象基类
 * 桥接模式
 * 适配模式：在实现时进行了转换、决定适配何种对象
 */
public class AbstractCourse implements ICourse {
    private INote note;
    private IVideo video;

    public void setNote(INote note) {
        this.note = note;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "note=" + note +
                ", video=" + video +
                '}';
    }
}
