###组合模式
从上面我们可以看到，组合模式可以使用一棵树来表示，一共有三个角色：

（1）组合部件（Component）：它是一个抽象接口。这里表示树根School

（2）叶子（Leaf）：在组合中表示子节点对象，这里表示的是网络部InternetDepartment，其没有孩子了。

（3）合成部件（Composite）：表示自己还有孩子，这里表示的是分校BranchSchool。

ok1，下面代码实现一下组合模式。