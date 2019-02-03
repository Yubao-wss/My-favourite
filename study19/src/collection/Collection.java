package collection;

/**
 * @Author: WSS
 * @Date:
 * @Description: Collection接口
 *
 * //Collection 表示一组对象，它是集中、收集的意思。Collection接口的两个子接口是List、Set接口。
 *   Collection中的方法：            方法                                     说明
 *                      boolean add(Object element)                   增加元素到容器中
 *                      boolean remove(Object element)                从容器中移除元素
 *                      boolean contains(Object element)            容器中是否包含该元素
 *                      int size()                                    容器中元素的数量
 *                      boolean isEmpty()                              容器是否为空
 *                      void clear()                                 清空容器中所有元素
 *                      Iterator iterator()                      获得迭代器，用于遍历所有元素
 *                      boolean containsAll(Collection c)      本容器是否包含c容器中的所有元素
 *                      boolean addAll(Collection c)            将容器c中所有元素增加到本容器
 *                      boolean removeAll(Collection c)        移除本容器和容器c中都包含的元素
 *                      boolean retainAll(Collection c)  取本容器和容器c中都包含的元素，移除非交集元素
 *                      Object[] toArray()                          转化成Object数组
 *
 *
 *                      由于List、Set是Collection的子接口，意味着所有List、Set的实现类都有上面的方法。
 */
public class Collection {
}
