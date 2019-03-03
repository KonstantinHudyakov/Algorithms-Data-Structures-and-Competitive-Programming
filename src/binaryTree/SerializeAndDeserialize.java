package binaryTree;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        SerializeAndDeserialize obj = new SerializeAndDeserialize();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String res = obj.serialize(root);
        root = obj.deserialize(res);
        res = obj.serialize(root);
        //String res = obj.serialize(root);
        System.out.println(res);
    }

    public String serialize(TreeNode root) {
        if(root == null)
            return "*";
        String result = Integer.toString(root.val);
        result += " " + serialize(root.left);
        result += " " + serialize(root.right);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0 || data.charAt(0) == '*')
            return null;
        int spaceIndex = data.indexOf(" ");
        String s = "";
        TreeNode root = null;
        if(spaceIndex != -1) {
            s = data.substring(0, spaceIndex);
            root = new TreeNode(Integer.parseInt(s));
            String newData = buildStr(data.substring(spaceIndex + 1));
            root.left = deserialize(newData);
            root.right = deserialize(data.substring(spaceIndex + newData.length() + 2));
        }
        else {
            s = data;
            root = new TreeNode(Integer.parseInt(s));
        }

        return root;
    }

    public String buildStr(String data) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        if(!data.substring(0, data.indexOf(" ")).equals("*"))
            count += 2;
        result.append(data.substring(0, data.indexOf(" ")));
        int lastIndex = result.length() + 1;
        while(count > 0) {
            int newIndex = data.indexOf(" ", lastIndex);
            String s = "";
            if(newIndex != -1)
                s = data.substring(lastIndex, newIndex);
            else
                s = data.substring(lastIndex);
            count--;
            if(!s.equals("*"))
                count += 2;
            result.append(" " + s);
            lastIndex = newIndex + 1;
        }
        return result.toString();
    }
}
