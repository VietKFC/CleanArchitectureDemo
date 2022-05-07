package com.example.domain.repository.mapper

interface ModelMapper<E, M> {
    interface MappingToModel<E, M> {
        fun toEntity(model: M): E
        fun fromEntity(entity: E): M
    }

    interface MappingToListModel<E, M> {
        fun fromEntities(entities: List<E>): List<M>
        fun toEntities(models: List<M>): List<E>
    }
}
