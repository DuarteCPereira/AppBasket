package duarte.pereira.appbasket.feature_basket.data.mapper

import duarte.pereira.appbasket.feature_basket.data.local.dto.LocalAppItem
import duarte.pereira.appbasket.feature_basket.data.remote.dto.RemoteAppItem
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem

//fun AppItem.toLocalAppItem(): LocalAppItem =
//    LocalAppItem(
//        name = name,
//        packageName = packageName,
//        icon = icon,
//        graphic = graphic,
//        id = id
//    )

//fun AppItem.toRemoteAppItem(): RemoteAppItem =
//    RemoteAppItem(
//        name = name,
//        packageName = packageName,
//        icon = icon,
//        graphic = graphic,
//        id = id
//    )

//fun LocalAppItem.toAppItem(): AppItem =
//    AppItem(
//        name = name,
//        packageName = packageName,
//        icon = icon,
//        graphic = graphic,
//        id = id
//    )

fun LocalAppItem.toRemoteAppItem(): RemoteAppItem =
    RemoteAppItem(
        id = id,
        name = name,
        packageName = name,
        store_id = store_id,
        store_name = store_name,
        vername = vername,
        vercode = vercode,
        md5sum = md5sum,
        apk_tags = emptyList(),
        size = size,
        downloads = downloads,
        pdownloads = pdownloads,
        added = added,
        modified = modified,
        updated = updated,
        rating = rating,
        icon = icon,
        graphic = graphic,
        uptype = uptype
    )

//fun RemoteAppItem.toAppItem(): AppItem {
//    return AppItem(
//        name = name,
//        packageName = packageName,
//        icon = icon,
//        graphic = graphic,
//        id = id
//    )
//}

fun RemoteAppItem.toLocalAppItem(): LocalAppItem {
    return LocalAppItem(
        id = id,
        name = name,
        packageName = name,
        store_id = store_id,
        store_name = store_name,
        vername = vername,
        vercode = vercode,
        md5sum = md5sum,
//        apk_tags = apk_tags,
        size = size,
        downloads = downloads,
        pdownloads = pdownloads,
        added = added,
        modified = modified,
        updated = updated,
        rating = rating,
        icon = icon,
        graphic = graphic,
        uptype = uptype
    )
}

//fun List<AppItem>.toLocalAppItemList(): List<LocalAppItem> =
//    this.map { app ->
//        LocalAppItem(
//            name = app.name,
//            packageName = app.packageName,
//            icon = app.icon,
//            graphic = app.graphic,
//            id = app.id
//        )
//    }

//fun List<AppItem>.toRemoteAppItemList(): List<RemoteAppItem> =
//    this.map { app ->
//        RemoteAppItem(
//            name = app.name,
//            packageName = app.packageName,
//            icon = app.icon,
//            graphic = app.graphic,
//            id = app.id
//        )
//    }

fun List<LocalAppItem>.toAppItemListFromLocal(): List<AppItem> =
    this.map { app ->
        AppItem(
            name = app.name,
            packageName = app.packageName,
            icon = app.icon,
            graphic = app.graphic,
            id = app.id,
            downloads = app.downloads,
            rating = app.rating,
            size = app.size
        )
    }

//fun List<LocalAppItem>.toRemoteItemListFromLocal(): List<RemoteAppItem> =
//    this.map { app ->
//        RemoteAppItem(
//            name = app.name,
//            packageName = app.packageName,
//            icon = app.icon,
//            graphic = app.graphic,
//            id = app.id
//        )
//    }

//fun List<RemoteAppItem>.toAppItemListFromRemote(): List<AppItem> =
//    this.map { app ->
//        AppItem(
//            name = app.name,
//            packageName = app.packageName,
//            icon = app.icon,
//            graphic = app.graphic,
//            id = app.id
//        )
//    }

fun List<RemoteAppItem>.toLocalItemListFromRemote(): List<LocalAppItem> =
    this.map { app ->
        LocalAppItem(
            id = app.id,
            name = app.name,
            packageName = app.name,
            store_id = app.store_id,
            store_name = app.store_name,
            vername = app.vername,
            vercode = app.vercode,
            md5sum = app.md5sum,
//            apk_tags = app.apk_tags,
            size = app.size,
            downloads = app.downloads,
            pdownloads = app.pdownloads,
            added = app.added,
            modified = app.modified,
            updated = app.updated,
            rating = app.rating,
            icon = app.icon,
            graphic = app.graphic,
            uptype = app.uptype
        )
    }
