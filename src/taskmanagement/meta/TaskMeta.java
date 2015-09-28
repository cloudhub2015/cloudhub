package taskmanagement.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-09-28 20:09:17")
/** */
public final class TaskMeta extends org.slim3.datastore.ModelMeta<taskmanagement.model.Task> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long> currentDate = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long>(this, "currentDate", "currentDate", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Double> estHours = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Double>(this, "estHours", "estHours", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean> finished = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean>(this, "finished", "finished", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean> pending = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean>(this, "pending", "pending", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean> today = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Boolean>(this, "today", "today", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> name = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task> phase = new org.slim3.datastore.StringAttributeMeta<taskmanagement.model.Task>(this, "phase", "phase");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Double> spentHours = new org.slim3.datastore.CoreAttributeMeta<taskmanagement.model.Task, java.lang.Double>(this, "spentHours", "spentHours", double.class);

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
        model.setCurrentDate(longToPrimitiveLong((java.lang.Long) entity.getProperty("currentDate")));
        model.setEstHours(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("estHours")));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setFinished(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("finished")));
        model.setPending(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("pending")));
        model.setToday(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("today")));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPhase((java.lang.String) entity.getProperty("phase"));
        model.setSpentHours(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("spentHours")));
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
        entity.setProperty("currentDate", m.getCurrentDate());
        entity.setProperty("estHours", m.getEstHours());
        entity.setProperty("id", m.getId());
        entity.setProperty("finished", m.isFinished());
        entity.setProperty("pending", m.isPending());
        entity.setProperty("today", m.isToday());
        entity.setProperty("name", m.getName());
        entity.setProperty("phase", m.getPhase());
        entity.setProperty("spentHours", m.getSpentHours());
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
        writer.setNextPropertyName("currentDate");
        encoder0.encode(writer, m.getCurrentDate());
        writer.setNextPropertyName("estHours");
        encoder0.encode(writer, m.getEstHours());
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        writer.setNextPropertyName("finished");
        encoder0.encode(writer, m.isFinished());
        writer.setNextPropertyName("pending");
        encoder0.encode(writer, m.isPending());
        writer.setNextPropertyName("today");
        encoder0.encode(writer, m.isToday());
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
        writer.setNextPropertyName("spentHours");
        encoder0.encode(writer, m.getSpentHours());
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
        reader = rootReader.newObjectReader("currentDate");
        m.setCurrentDate(decoder0.decode(reader, m.getCurrentDate()));
        reader = rootReader.newObjectReader("estHours");
        m.setEstHours(decoder0.decode(reader, m.getEstHours()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("finished");
        m.setFinished(decoder0.decode(reader, m.isFinished()));
        reader = rootReader.newObjectReader("pending");
        m.setPending(decoder0.decode(reader, m.isPending()));
        reader = rootReader.newObjectReader("today");
        m.setToday(decoder0.decode(reader, m.isToday()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("phase");
        m.setPhase(decoder0.decode(reader, m.getPhase()));
        reader = rootReader.newObjectReader("spentHours");
        m.setSpentHours(decoder0.decode(reader, m.getSpentHours()));
        reader = rootReader.newObjectReader("userId");
        m.setUserId(decoder0.decode(reader, m.getUserId()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}