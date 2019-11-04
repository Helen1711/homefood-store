package ua.com.lena.homefoodstore.repository.custom.impl;

import org.springframework.stereotype.Repository;
import ua.com.lena.homefoodstore.repository.custom.CategoryRepositoryCustom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    private final EntityManager entityManager;

    public CategoryRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public int drop(Long id) {
        return entityManager
                .createNativeQuery("delete from homefoodTest.category where id = ? and " +
                        "not exists(select * from homefoodTest.product where category_id = ?)")
                .setParameter(1, id)
                .setParameter(2, id)
                .executeUpdate();
    }
}
