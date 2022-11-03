import React from 'react'

const ItemModalView = props => {
  return (
    <div>
        <div className="modal">
            <div className="modal-content">
                <div className="modal-header">
                    <h4 className="modal-title">Item Modal View</h4>
                </div>
                <div className="modal-body">
                  This is modal content
                </div>
                <div className="modal-footer">
                  <button className="button">Close</button>
                </div>
            </div>
        </div>
    </div>
  )
}

export default ItemModalView