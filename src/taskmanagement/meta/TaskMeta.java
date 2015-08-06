package taskmanagement.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-08-06 15:42:11")
/** */
public final class TaskMeta extends org.slim3.datastore.ModelMeta<taskmanagement.model.Task> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> content = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "content", "content");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> createdDate = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "createdDate", "createdDate");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Integer> doneRatio = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Integer>(this, "doneRatio", "doneRatio", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> dueDate = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "dueDate", "dueDate");

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<taskmanagement.model.Task, java.util.List<java.lang.String>> errorList = new org.slim3.datastore.StringCollectionAttributeMeta<taskmanagement.model.Task, java.util.List<java.lang.String>>(this, "errorList", "errorList", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Float> estHours = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Float>(this, "estHours", "estHours", float.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> name = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> phase = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "phase", "phase");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> startDate = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "startDate", "startDate");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long> userId = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long>(this, "userId", "userId", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TaskMeta slim3_singleton = new TaskMeta();

    /**
     * @return the singleton
     */
    public static TaskMeta get() {
       return slim3_singleton;
    }

    /** */
    public TaskMeta() {
        super("Task", taskmanagement.model.Task.class);
    }

    @Override
    public taskmanagement.model.Task entityToModel(com.google.appengine.api.datastore.Entity entity) {
        taskmanagement.model.Task model = new taskmanagement.model.Task();
        model.setContent((java.lang.String) entity.getProperty("content"));
        model.setCreatedDate((java.lang.String) entity.getProperty("createdDate"));
        model.setDoneRatio(longToPrimitiveInt((java.lang.Long) entity.getProperty("doneRatio")));
        model.setDueDate((java.lang.String) entity.getProperty("dueDate"));
        model.setErrorList(toList(java.lang.String.class, entity.getProperty("errorList")));
        model.setEstHours(doubleToPrimitiveFloat((java.lang.Double) entity.getProperty("estHours")));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPhase((java.lang.String) entity.getProperty("phase"));
        model.setStartDate((java.lang.String) entity.getProperty("startDate"));
        model.setUserId(longToPrimitiveLong((java.lang.Long) entity.getProperty("userId")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("content", m.getContent());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("doneRatio", m.getDoneRatio());
        entity.setProperty("dueDate", m.getDueDate());
        entity.setProperty("errorList", m.getErrorList());
        entity.setProperty("estHours", m.getEstHours());
        entity.setProperty("id", m.getId());
        entity.setProperty("name", m.getName());
        entity.setProperty("phase", m.getPhase());
        entity.setProperty("startDate", m.getStartDate());
        entity.setProperty("userId", m.getUserId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        taskmanagement.model.Task m = (taskmanagement.model.Task) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        writer.setNextPropertyName("doneRatio");
        encoder0.encode(writer, m.getDoneRatio());
        if(m.getDueDate() != null){
            writer.setNextPropertyName("dueDate");
            encoder0.encode(writer, m.getDueDate());
        }
        if(m.getErrorList() != null){
            writer.setNextPropertyName("errorList");
            writer.beginArray();
            for(java.lang.String v : m.getErrorList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        writer.setNextPropertyName("estHours");
        encoder0.encode(writer, m.getEstHours());
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getPhase() != null){
            writer.setNextPropertyName("phase");
            encoder0.encode(writer, m.getPhase());
        }
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
        }
        writer.setNextPropertyName("userId");
        encoder0.encode(writer, m.getUserId());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected taskmanagement.model.Task jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        taskmanagement.model.Task m = new taskmanagement.model.Task();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("doneRatio");
        m.setDoneRatio(decoder0.decode(reader, m.getDoneRatio()));
        reader = rootReader.newObjectReader("dueDate");
        m.setDueDate(decoder0.decode(reader, m.getDueDate()));
        reader = rootReader.newObjectReader("errorList");
        {
            java.util.ArrayList<java.lang.String> elements = new java.util.ArrayList<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("errorList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setErrorList(elements);
            }
        }
        reader = rootReader.newObjectReader("estHours");
        m.setEstHours(decoder0.decode(reader, m.getEstHours()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("phase");
        m.setPhase(decoder0.decode(reader, m.getPhase()));
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
        reader = rootReader.newObjectReader("userId");
        m.setUserId(decoder0.decode(reader, m.getUserId()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}