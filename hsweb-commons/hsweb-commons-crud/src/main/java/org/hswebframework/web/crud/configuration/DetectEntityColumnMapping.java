package org.hswebframework.web.crud.configuration;

import org.hswebframework.ezorm.rdb.mapping.EntityColumnMapping;
import org.hswebframework.ezorm.rdb.mapping.MappingFeatureType;
import org.hswebframework.ezorm.rdb.metadata.RDBColumnMetadata;

import java.util.Map;
import java.util.Optional;

class DetectEntityColumnMapping implements EntityColumnMapping {
    private final String id;
    private final Class<?> type;
    private final EntityColumnMapping mapping;

    public DetectEntityColumnMapping(Class<?> type,
                                     EntityColumnMapping mapping) {
        this.id = MappingFeatureType.columnPropertyMapping.createFeatureId(type);
        this.type = type;
        this.mapping = mapping;
    }

    @Override
    public Class<?> getEntityType() {
        return type;
    }

    @Override
    public Optional<RDBColumnMetadata> getColumnByProperty(String property) {
        return  mapping.getColumnByProperty(property);
    }

    @Override
    public Optional<String> getPropertyByColumnName(String columnName) {
        return  mapping.getPropertyByColumnName(columnName);
    }

    @Override
    public Optional<RDBColumnMetadata> getColumnByName(String columnName) {
        return mapping.getColumnByName(columnName);
    }

    @Override
    public Map<String, String> getColumnPropertyMapping() {
        return mapping.getColumnPropertyMapping();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return getId();
    }
}
