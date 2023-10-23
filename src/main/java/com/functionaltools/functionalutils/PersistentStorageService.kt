package com.functionaltools.functionalutils

//TODO: WIP
class PersistentStorageService<ENTITY: Any, LDM: Any, KEY: Any> {
//    (
//    private val repository: CrudRepository<ENTITY, KEY>,
//    private val lDMToEntity: OneToOneTransformer<LDM, ENTITY>,
//    private val entityToLDM: OneToOneTransformer<ENTITY, LDM>) {
//
//    fun save(toSave: LDM): LDM {
//        return toSave
//            .let { lDMToEntity.transform(it) }
//            .let { repository.save(it) }
//            .let { entityToLDM.transform(it) }
//    }
//
//    fun retrieve(userToken: KEY): LDM? {
//        return repository.findById(userToken)
//            .map { entityToLDM.transform(it) }.orElse(null)
//    }
//
//    fun retrieveOrThrow(userToken: KEY, exception: Exception): LDM? {
//        return repository.findById(userToken)
//            .map { entityToLDM.transform(it) }
//            .orElseThrow { throw exception }
//    }
}