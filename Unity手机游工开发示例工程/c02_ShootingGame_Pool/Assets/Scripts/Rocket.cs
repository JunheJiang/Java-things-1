using UnityEngine;
using System.Collections;

[AddComponentMenu("MyGame/Rocket")]
public class Rocket : MonoBehaviour {

    public float m_speed = 10;  // 子弹飞行速度
    public float m_power = 1.0f;  // 威力

	// Update is called once per frame
	void Update () {
        transform.Translate( new Vector3( 0, 0, m_speed * Time.deltaTime ) );  // 向前移动
	}

    void OnTriggerEnter(Collider other)
    {
        if (other.tag!="Enemy")
            return;

        Despawn();
    }

    void OnBecameInvisible()
    {
        Despawn();
    }

    void Despawn()
    {
        if (!gameObject.activeSelf)
            return;

        var p = PathologicalGames.PoolManager.Pools["mypool"];
        
        if (p.IsSpawned(transform)) // 判断当前对象是否在对象池中
            p.Despawn(transform);  // 如果在则还回对象池
        else
            Destroy(gameObject); // 如果不在则销毁
    }

}
