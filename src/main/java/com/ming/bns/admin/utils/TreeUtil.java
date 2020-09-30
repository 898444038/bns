package com.ming.bns.admin.utils;

import java.util.*;

public class TreeUtil {

    public static <T> TreeNode getTree(List<T> data){
        try {
            List<Map<String, Object>> list = ConvertUtil.convertListBean2ListMap(data);
            return getTree(list,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTree(null,null);
    }

    private static TreeNode getTree(List<Map<String, Object>> data, TreeNode tree){
        if(tree != null){
            int id = tree.getId();
            List<TreeNode> children = tree.getChildren();
            for(Map<String, Object> map : data){
                Integer parentid = Integer.valueOf(map.get("parentId").toString());
                if(parentid == id){
                    TreeNode t = new TreeNode();
                    t.setId(Integer.valueOf(map.get("id").toString()));
                    t.setName(map.get("name").toString());
                    t.setParentId(Integer.valueOf(map.get("parentId").toString()));
                    t.setChildren(new ArrayList<TreeNode>());
                    children.add(t);
                    getTree(data, t);
                }
            }
            tree.setChildren(children);
        }else{
            tree = new TreeNode();
            tree.setId(0);
            tree.setName("顶级");
            tree.setParentId(0);
            tree.setChildren(new ArrayList<TreeNode>());
            getTree(data, tree);
        }
        return tree;
    }



    /**
     * 深度优先遍历（非递归方式） ----- 查找树的所有叶子路径
     *
     * @param root
     *            根节点
     * @return 叶子路径的集合
     */
    public static List<List<TreeNode>> dfsTree(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<List<TreeNode>> pathStack = new Stack<>();
        List<List<TreeNode>> result = new ArrayList<>();
        nodeStack.push(root);
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        pathStack.push(arrayList);

        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            List<TreeNode> curPath = pathStack.pop();

            if (curNode.getChildren() == null || curNode.getChildren().size() <= 0) {
                result.add(curPath);
            } else {
                int childSize = curNode.getChildren().size();
                for (int i = childSize - 1; i >= 0; i--) {
                    TreeNode node = curNode.getChildren().get(i);
                    nodeStack.push(node);
                    List<TreeNode> list = new ArrayList<>(curPath);
                    list.add(node);
                    pathStack.push(list);
                }
            }
        }
        return result;
    }


    /**
     * 深度优先遍历（非递归方式） ----- 查找树的所有叶子路径
     *
     * @param root
     *            根节点
     * @return 叶子路径的集合
     */
    public static List<List<TreeNode>> dfsTree2(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<List<TreeNode>> pathStack = new Stack<>();
        List<List<TreeNode>> result = new ArrayList<>();
        nodeStack.push(root);
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        pathStack.push(arrayList);

        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.pop();
            List<TreeNode> curPath = pathStack.pop();

            if (curNode.getChildren() == null || curNode.getChildren().size() <= 0) {
                result.add(curPath);
            } else {
                int childSize = curNode.getChildren().size();
                for (int i = childSize - 1; i >= 0; i--) {
                    TreeNode node = curNode.getChildren().get(i);
                    nodeStack.push(node);
                    List<TreeNode> list = new ArrayList<>(curPath);
                    list.add(node);
                    pathStack.push(list);
                }
            }
        }
        return result;
    }

    /**
     * 广度优先遍历 ---- 查找树的所有叶子路径
     *
     * @param root
     *            根节点
     * @return 叶子路径的集合
     */
    public static List<List<TreeNode>> bfsTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<List<TreeNode>> qstr = new LinkedList<>();
        List<List<TreeNode>> result = new ArrayList<>();
        nodeQueue.add(root);
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        qstr.add(arrayList);

        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.remove();
            List<TreeNode> curList = qstr.remove();

            if (curNode.getChildren() == null || curNode.getChildren().size() <= 0) {
                curList.add(curNode);
                result.add(curList);
            } else {
                for (int i = 0; i < curNode.getChildren().size(); i++) {
                    TreeNode treeNode = curNode.getChildren().get(i);
                    nodeQueue.add(treeNode);
                    List<TreeNode> list = new ArrayList<>(curList);
                    list.add(curNode);
                    qstr.add(list);
                }
            }
        }
        return result;
    }
}
