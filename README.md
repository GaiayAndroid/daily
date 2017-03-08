# daily
每日一题  
提交代码相关命令：

            1.生成ssh秘钥，上传公钥到自己账户 ssh-keygen -t rsa -C ${your email}  
            2.从github仓库克隆代码（在指定目录下打开gitbush）   git clone git@github.com:GaiayAndroid/daily.git  
            3.关联仓库 git remote add origin git@github.com:GaiayAndroid/daily.git  
            4.注意，提交之前需要同步github上的代码 git fetch origin master:temp（用temp分支去拉代码)  
            5.然后与主分支对比（git diff temp）,然后将temp分支合并到主分支（git merge temp）,删除temp分支（git branch -d temp  
            6.粘贴要提交的文件到目录下，然后 git add . --> git commit -m "注释"  
            7.同步之后再提交 git push origin master  
            8.如果你提目录结构交错了，不要在github上删除任何东西，正确的做法应该是：先在本地删除自己提交错的文件，保持之前的结构，然后修改成正确的文件结构，最后同步到github上。
