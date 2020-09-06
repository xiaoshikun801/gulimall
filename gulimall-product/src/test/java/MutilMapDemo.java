import com.google.common.collect.ArrayListMultimap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MutilMapDemo {
    public static void main(String[] args) {


        List<Entity> entities = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Entity entity = new Entity();
            entity.setId(i+1);
            entity.setCid(i % 10 == 0 ? 2 : 3);
            entity.setName("name"+(i+1));
            entity.setContent("content"+i);
            entity.setMoney(BigDecimal.TEN);
            entities.add(entity);
        }

        entities.forEach(System.out::println);

        ArrayListMultimap<Integer,VO> multimap = ArrayListMultimap.create();
        for (Entity entity : entities){
                VO vo = new VO();
                BeanUtils.copyProperties(entity,vo);
                multimap.put(entity.getCid(),vo);
        }


        for (Integer key : multimap.keySet()){
            List<VO> vos = multimap.get(key);
//            System.out.println(key+":"+ StringUtils.join(vos,","));
            System.out.println(key+":"+vos);
        }

    }



}

class VO implements Serializable {
    private Integer id;
    private String name;
    private BigDecimal money;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "VO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", content='" + content + '\'' +
                '}';
    }
}

class Entity implements Serializable{
    private Integer id;
    private Integer cid;
    private String name;
    private BigDecimal money;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", content='" + content + '\'' +
                '}';
    }
}
