"""
本脚本为《Unity3d/2d手机游戏开发（第4版)》的教学代码,
"""
import os
import shutil


# 定义一个函数，从Unity中导出Android工程文件
def export_android(unity_ed_path, project_path, log_path):

    # 如果当前工程已经存在，删除这个工程
    if os.path.exists('./export project'):
        shutil.rmtree('./export project')

    # 将Unity可执行文件添加到环境变量路径
    os.putenv("path", unity_ed_path)

    # unity命令行
    command = 'Unity.exe -quit -batchmode -projectPath {0} -logFile {1}\
     -executeMethod GameBuilder.BuildForAndroid'.format(project_path, log_path)

    # 执行命行令
    os.system(command)

    print('Android工程导出完成')


def build_android():
    pass


if __name__ == '__main__':
    # Unity编辑器安装路径
    unity_editor_path = 'D:/Program Files/Unity/Editor'
    # Unity工程的绝对路径
    unity_project_path = os.path.abspath(os.curdir) # 获得当前路径的绝对路径
    # Log存放位置
    build_log_path = os.path.join(unity_project_path, 'buildlog.txt')

    # 执行export_android函数
    # export_android(unity_editor_path, unity_project_path, build_log_path)

    # 备份文件位置
    source = './UnityPlayerActivity.java'
    # 目标位置
    target = './export project/SimpleAndroid/src/main/java/com/demo/simpleandroid/UnityPlayerActivity.java'
    # 执行复制
    shutil.copy(source, target)

