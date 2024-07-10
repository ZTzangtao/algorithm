package own_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Tommy
 * @Date 2024/7/10 21:38
 * @Version 1.0
 */
public class MergeTest240710 {


    static class Goods {


        String name;

        List<String> attrList;

        Integer count;

        public Goods() {
        }

        public Goods(String name, List<String> attrList, Integer count) {
            this.name = name;
            this.attrList = attrList;
            this.count = count;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getAttrList() {
            return attrList;
        }

        public void setAttrList(List<String> attrList) {
            this.attrList = attrList;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }





    }

    static List<Goods> mergeGoods(List<Goods> goodsList) {
        List<Goods> result = new ArrayList<>();
        HashMap<String, Goods> map = new HashMap<>();
        for (Goods goods : goodsList) {
            if (!map.containsKey(goods.getName())) {
                map.put(goods.getName(), goods);
            } else {
                Goods mapGoods = map.get(goods.getName());
                // 对比2个list元素是否相同
                List<String> mapAttrlist = mapGoods.getAttrList();
                Collections.sort(mapAttrlist);

                List<String> attrlist =  goods.getAttrList();
                Collections.sort(attrlist);

                if ( mapAttrlist.size() == attrlist.size()) {
                    boolean flag = true;
                    for (int i = 0; i < mapAttrlist.size(); i++) {
                        if (!mapAttrlist.get(i).equals(attrlist.get(i))) {
                            flag = false;
                            result.add(goods);
                        }
                    }
                    if (flag) {
                        mapGoods.setCount(goods.getCount() + mapGoods.getCount());
                        map.put(goods.getName(), mapGoods);
                    }
                } else {
                    result.add(goods);
                }
            }
        }

        map.forEach((k, v) -> {
            result.add(v);
        });

        return result;
    }

    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList();

        Goods goods1 = new Goods();
        goods1.setName("红富士");
        goods1.setCount(10);
        List<String> attrList = new ArrayList<>();
        attrList.add("红色");
        attrList.add("纯天然");
        attrList.add("很甜");
        goods1.setAttrList(attrList);

        Goods goods2 = new Goods();
        goods2.setName("红富士");
        goods2.setCount(2);
        List<String> attrList1 = new ArrayList<>();
        attrList1.add("很甜");
        attrList1.add("红色");
        attrList1.add("纯天然");
        goods2.setAttrList(attrList1);

        Goods goods3 = new Goods();
        goods3.setName("红富士");
        goods3.setCount(5);
        List<String> attrList2 = new ArrayList<>();
        attrList2.add("红色");
        attrList2.add("纯天然");
        goods3.setAttrList(attrList2);

        Goods goods4 = new Goods();
        goods4.setName("小金苹果");
        goods4.setCount(20);
        List<String> attrList3 = new ArrayList<>();
        attrList3.add("红色");
        attrList3.add("纯天然");
        goods4.setAttrList(attrList3);

        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);

        List<Goods> result = mergeGoods(goodsList);
        System.out.println(result.size());
        result.forEach(c -> {

            System.out.println(c.getName());
            System.out.println(c.getCount());
        });
    }



}
