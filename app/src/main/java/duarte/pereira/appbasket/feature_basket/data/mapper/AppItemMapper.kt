package duarte.pereira.appbasket.feature_basket.data.mapper

import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalAppItem
import duarte.pereira.appbasket.feature_basket.data.remote.dto.RemoteAppItem
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem

fun AppItem.toLocalAppItem(): LocalAppItem =
    LocalAppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )

fun AppItem.toRemoteAppItem(): RemoteAppItem =
    RemoteAppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )

fun LocalAppItem.toAppItem(): AppItem =
    AppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )

fun LocalAppItem.toRemoteAppItem(): RemoteAppItem =
    RemoteAppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )

fun RemoteAppItem.toAppItem(): AppItem{
    return AppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )
}

fun RemoteAppItem.toLocalAppItem(): LocalAppItem{
    return LocalAppItem(
        name = name,
        packageName = packageName,
        icon = icon,
        graphic = graphic,
        id = id
    )
}

fun List<AppItem>.toLocalAppItemList(): List<LocalAppItem>  =
    this.map { todo ->
        LocalAppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }

fun List<AppItem>.toRemoteAppItemList(): List<RemoteAppItem>  =
    this.map { todo ->
        RemoteAppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }

fun List<LocalAppItem>.toAppItemListFromLocal(): List<AppItem>  =
    this.map { todo ->
        AppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }

fun List<LocalAppItem>.toRemoteItemListFromLocal(): List<RemoteAppItem>  =
    this.map { todo ->
        RemoteAppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }

fun List<RemoteAppItem>.toAppItemListFromRemote(): List<AppItem>  =
    this.map { todo ->
        AppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }

fun List<RemoteAppItem>.toLocalItemListFromRemote(): List<LocalAppItem>  =
    this.map { todo ->
        LocalAppItem(
            name = todo.name,
            packageName = todo.packageName,
            icon = todo.icon,
            graphic = todo.graphic,
            id = todo.id
        )
    }
