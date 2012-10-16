package hu.nooon.dobido.server.database.entity;

import hu.nooon.dobido.server.database.EMF;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Entity
public class Dummy {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Version
    @Column(name = "version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public static EntityManager entityManager() {
        return EMF.get().createEntityManager();
    }

    public void persist() {
        EntityManager em = entityManager();
        try {
            em.persist(this);
        } finally {
            em.close();
        }
    }

    public void remove() {
        EntityManager em = entityManager();
        try {
            Dummy attached = em.find(Dummy.class, this.id);
            em.remove(attached);
        } finally {
            em.close();
        }
    }

    public static Long countDummies() {
        return ((Integer) entityManager().createQuery("select count(1) from Dummy d").getSingleResult()).longValue();
    }

    public static Dummy findDummy(Long id) {
        return null;
    }

    public static Dummy findByName(String name) {
        List<Dummy> resultList = entityManager().createQuery("select d from Dummy d where name like '" + name + "%'").getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);

//        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
//        CriteriaQuery<Dummy> cq = cb.createQuery(Dummy.class);
//        Root<Dummy> from = cq.from(Dummy.class);
//
//        cq.where(cb.equal(from.get("name"), name));
//
//        List<Dummy> resultList = entityManager().createQuery(cq).getResultList();
//
//        return resultList.isEmpty() ? null : resultList.get(0);
    }

}
