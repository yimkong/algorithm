package thread.testjoinforkpool;

import com.google.common.collect.Sets;

import java.util.Set;

public class TreeNode {
    int value;
    Set<TreeNode> childern;

    TreeNode(int value, TreeNode... children){
        this.value = value;
        this.childern = Sets.newHashSet(children);
    }
}
