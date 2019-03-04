//
// Created by George on 04/03/2019.
//

#include "pre.h"

#include "natives_blob.h"
#include "snapshot_blob.h"

void js::core::Pre::Initialize() {
    InitializeExternalStartupData();
}

void js::core::Pre::InitializeExternalStartupData() {
    auto *natives_blob = new js::core::Blob(natives_blob_bin, natives_blob_bin_len);
    auto *snapshot_blob = new js::core::Blob(snapshot_blob_bin, snapshot_blob_bin_len);

    v8::V8::SetNativesDataBlob(natives_blob->Mount());
    v8::V8::SetSnapshotDataBlob(snapshot_blob->Mount());
}
