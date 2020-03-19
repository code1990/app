package easykotlin;

import com.sun.istack.internal.NotNull;
import kotlin.jvm.internal.Intrinsics;

public final class DepartmentJava {
    private long id = -1L;
    @NotNull
    private String name = "Dept";

    public final long getId() {
        return this.id;
    }

    public final void setId(long var1) {
        this.id = var1;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }


    public final void setName(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.name = var1;
    }

}

