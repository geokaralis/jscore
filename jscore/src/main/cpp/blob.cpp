//
// Created by George on 04/03/2019.
//

#include "blob.h"

js::core::Blob::~Blob() {
    delete data;
    size = 0;
}

js::core::Blob::Blob(const unsigned char *data, unsigned int size)
    : data(data),
      size(size) { }

v8::StartupData *js::core::Blob::Mount() {
    auto startup_data = new v8::StartupData();
    startup_data->data = reinterpret_cast<const char*>(&this->data[0]);
    startup_data->raw_size = this->size;

    return startup_data;
}
