package com.example.doitremastered.data.mapper

import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import com.example.doitremastered.domain.entities.CategoryMain
import javax.inject.Inject

class CategoriesMapper @Inject constructor() {

    fun mapDtoToDomain(category: CategoryEntity) : CategoryMain {
        return with(category) {
            CategoryMain(
                id = id,
                name = name,
                isPrimary = isPrimary
            )
        }
    }

    fun mapDomainToDto(category: CategoryMain) : CategoryEntity {
        return with(category) {
            CategoryEntity(
                id = id,
                name = name,
                isPrimary = isPrimary
            )
        }
    }
}