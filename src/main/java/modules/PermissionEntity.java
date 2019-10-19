package modules;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "permissions", schema = "sda_proiect_comun1")
public class PermissionEntity {

    @Id
    @Column(name = "id", insertable = false, updatable = false,unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "bindUsersPermissionsEntities")
    private List<UserPermissionEntity> bindUsersPermissionsEntities;

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

    public List<UserPermissionEntity> getBindUsersPermissionsEntities() {
        return bindUsersPermissionsEntities;
    }

    public void setBindUsersPermissionsEntities(List<UserPermissionEntity> bindUsersPermissionsEntities) {
        this.bindUsersPermissionsEntities = bindUsersPermissionsEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionEntity that = (PermissionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(bindUsersPermissionsEntities, that.bindUsersPermissionsEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bindUsersPermissionsEntities);
    }

    @Override
    public String toString() {
        return "PermissionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
