package com.example.doitremastered.data.database.categories.dao

import androidx.room.*
import com.example.doitremastered.data.database.categories.entities.CategoryEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateCategory(category: CategoryEntity)

    @Query("SELECT * FROM categories WHERE name = :name")
    fun findCategoryByName(name: String): CategoryEntity

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Single<List<CategoryEntity>>

    @Delete
    fun delete(category: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMainCategories(categories: List<CategoryEntity>)
}