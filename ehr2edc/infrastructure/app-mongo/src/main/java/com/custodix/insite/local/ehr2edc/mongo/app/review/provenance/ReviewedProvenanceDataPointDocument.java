package com.custodix.insite.local.ehr2edc.mongo.app.review.provenance;

import com.custodix.insite.local.ehr2edc.provenance.model.ProvenanceDataPoint;

public interface ReviewedProvenanceDataPointDocument {

	ProvenanceDataPoint restore();
}
